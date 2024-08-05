package com.partners.tickets;



import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.partners.tickets.resolver.TicketDataFetcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class GraphQLConfig {

//    @Bean
//    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
//        return GraphQL.newGraphQL(graphQLSchema).build();
//    }
//
//    @Bean
//    public GraphQLSchema graphQLSchema() throws IOException {
//        SchemaParser schemaParser = new SchemaParser();
//        SchemaGenerator schemaGenerator = new SchemaGenerator();
//        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(loadSchema());
//
//        // Configura el RuntimeWiring usando el nuevo enfoque
//        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
//                .type("Query", builder -> builder
//                        .dataFetcher("tickets", new TicketDataFetcher()) // Reemplaza con tu DataFetcher
//                        .dataFetcher("ticket", new TicketDataFetcher())) // Reemplaza con tu DataFetcher
//                .type("Mutation", builder -> builder
//                        .dataFetcher("createTicket", new CreateTicketDataFetcher()) // Reemplaza con tu DataFetcher
//                        .dataFetcher("updateTicket", new UpdateTicketDataFetcher()) // Reemplaza con tu DataFetcher
//                        .dataFetcher("deleteTicket", new DeleteTicketDataFetcher())) // Reemplaza con tu DataFetcher
//                .build();
//
//        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
//    }
//
//    private String loadSchema() throws IOException {
//        // Carga tu esquema desde un archivo o fuente
//        return new String(Files.readAllBytes(Paths.get("src/main/resources/graphql/schema.graphqls")));
//    }
}




