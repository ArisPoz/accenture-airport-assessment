package com.pozidis.airportassessment.config;

import com.pozidis.airportassessment.domain.Airport;
import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.domain.Runway;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * @author arist
 */

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;

    public JobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, DataSource dataSource) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }

    @Bean
    public Job csvJob() {
        return jobBuilderFactory
                .get("csvJob")
                .incrementer(new RunIdIncrementer())
                .start(parseCountriesCsv())
                .build();
    }

    @Bean
    public Step parseAirportsCsv() {

        String sql = "INSERT INTO AIRPORT (ID, IDENT, TYPE, NAME, LATITUDE_DEG, LONGITUDE_DEG, ELEVATION_FT, CONTINENT, ISO_COUNTRY, ISO_REGION, " +
                "MUNICIPALITY, SCHEDULED_SERVICE, GPS_CODE, IATA_CODE, LOCAL_CODE, HOME_LINK, WIKIPEDIA_LINK, KEYWORDS) " +
                "VALUES (:id, :ident, :type, :name, :latitudeDeg, :longitudeDeg, :elevationFt, :continent, :isoCountry, :isoRegion, " +
                ":municipality, :scheduledService, :gpsCode, :iataCode, :localCode, :homeLink, :wikipediaLink, :keywords) ";

        String[] columns = new String[]{"ID", "IDENT", "TYPE", "NAME", "LATITUDE_DEG", "LONGITUDE_DEG", "ELEVATION_FT", "CONTINENT", "ISO_COUNTRY", "ISO_REGION",
                "MUNICIPALITY", "SCHEDULED_SERVICE", "GPS_CODE", "IATA_CODE", "LOCAL_CODE", "HOME_LINK", "WIKIPEDIA_LINK", "KEYWORDS"};

        return stepBuilderFactory
                .get("parseAirportsCsv")
                .<Airport, Airport>chunk(100)
                .reader(reader("/csv/airports.csv", Airport.class, columns))
                .writer(writer(sql))
                .build();
    }

    @Bean
    public Step parseCountriesCsv() {

        String sql = "INSERT INTO COUNTRY (ID, CODE, NAME, CONTINENT, WIKIPEDIA_LINK, KEYWORDS) " +
                "VALUES (:id, :code, :name, :continent, :wikipediaLink, :keywords) ";

        String[] columns = new String[]{"ID", "CODE", "NAME", "CONTINENT", "WIKIPEDIA_LINK", "KEYWORDS"};

        return stepBuilderFactory
                .get("parseCountriesCsv")
                .<Country, Country>chunk(100)
                .reader(reader("/csv/countries.csv", Country.class, columns))
                .writer(writer(sql))
                .build();
    }

    @Bean
    public Step parseRunwaysCsv() {

        String sql = "INSERT INTO RUNWAY (ID, AIRPORT_REF, AIRPORT_IDENT, LENGTH_FT, WIDTH_FT, SURFACE, LIGHTED, CLOSED, " +
                "LE_IDENT, LE_LATITUDE_DEG, LE_LONGITUDE_DEG, LE_ELEVATION_FT, LE_HEADING_DEGT, LE_DISPLACED_THRESHOLD_FT, " +
                "HE_IDENT, HE_LATITUDE_DEG, HE_LONGITUDE_DEG, HE_ELEVATION_FT, HE_HEADING_DEGT, HE_DISPLACED_THRESHOLD_FT) " +
                "VALUES (:id, :airportRef, :airportIdent, :lengthFt, :widthFt, :surface, :lighted, :closed, " +
                ":leIndent, :leLatitudeDeg, :leLongitudeDeg, :leElevationFt, :leHeadingDegt, :leDisplacedThresholdFt, " +
                ":heIndent, :heLatitudeDeg, :heLongitudeDeg, :heElevationFt, :heHeadingDegt, :heDisplacedThresholdFt, ) ";

        String[] columns = new String[]{"ID", "AIRPORT_REF", "AIRPORT_IDENT", "LENGTH_FT", "WIDTH_FT", "SURFACE", "LIGHTED", "CLOSED",
                "LE_IDENT", "LE_LATITUDE_DEG", "LE_LONGITUDE_DEG", "LE_ELEVATION_FT", "LE_HEADING_DEGT", "LE_DISPLACED_THRESHOLD_FT",
                "HE_IDENT", "HE_LATITUDE_DEG", "HE_LONGITUDE_DEG", "HE_ELEVATION_FT", "HE_HEADING_DEGT", "HE_DISPLACED_THRESHOLD_FT"};

        return stepBuilderFactory
                .get("parseRunwaysCsv")
                .<Runway, Runway>chunk(100)
                .reader(reader("/csv/runways.csv", Runway.class, columns))
                .writer(writer(sql))
                .build();
    }

    @Bean
    public <E> FlatFileItemReader<E> reader(String path, Class<E> type, String... columns) {
        FlatFileItemReader<E> itemReader = new FlatFileItemReader<>();
        itemReader.setLineMapper(lineMapper(type, columns));
        itemReader.setLinesToSkip(1);
        itemReader.setResource(new ClassPathResource(path));
        return itemReader;
    }

    @Bean
    public <E> JdbcBatchItemWriter<E> writer(String sqlInsert) {
        JdbcBatchItemWriter<E> itemWriter = new JdbcBatchItemWriter<>();

        itemWriter.setDataSource(dataSource);
        itemWriter.setSql(sqlInsert);
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

        return itemWriter;
    }

    @Bean
    public <E> LineMapper<E> lineMapper(Class<E> type, String... columns) {
        DefaultLineMapper<E> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        BeanWrapperFieldSetMapper<E> fieldSetMapper = new BeanWrapperFieldSetMapper<>();

        lineTokenizer.setNames(columns);
        fieldSetMapper.setTargetType(type);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }
}
