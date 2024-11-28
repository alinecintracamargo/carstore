package br.com.carstore.config;


import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPoolConfig {

    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource() {

        if (dataSource == null) {

            dataSource = new BasicDataSource();

            dataSource.setUrl("jdbc:h2:~/test");
            dataSource.setUsername("sa");
            dataSource.setPassword("sa");
            dataSource.setMinIdle(5);   // Número mínimo de conexões ociosas no pool
            dataSource.setMaxIdle(10);  // Número máximo de conexões ociosas no pool
            dataSource.setMaxTotal(50); // Número máximo de conexões totais no pool

            System.out.println("New connection pool created with successful");


        }

        return dataSource;
    }

}









