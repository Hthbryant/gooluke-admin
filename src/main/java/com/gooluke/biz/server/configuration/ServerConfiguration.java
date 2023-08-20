package com.gooluke.biz.server.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.gooluke.biz.server.interceptor.AuthInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * @author 咕噜科
 * ClassName: ServerConfiguration
 * date: 2023-08-15 22:33
 * Description:
 * version 1.0
 */
@Configuration
public class ServerConfiguration implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(ServerConfiguration.class);

    @Autowired
    private AuthInterceptor authInterceptor;

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:/mapper/*.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("create sqlSessionFactoryBean error", e);
            throw new RuntimeException("create sqlSessionFactoryBean error");
        }
    }

    @Bean("dataSource")
    public DataSource dataSource(@Value("${jdbc.datasource.driverClassName}") String driverClassName,
                                    @Value("${jdbc.datasource.url}") String url,
                                    @Value("${jdbc.datasource.username}") String username,
                                    @Value("${jdbc.datasource.password}") String password
    ) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePathPatterns = {
                "/login",
                "/logout",
                "/op/**"
        };

        // 注册拦截器
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns)
                .order(1)
        ;
    }

}
