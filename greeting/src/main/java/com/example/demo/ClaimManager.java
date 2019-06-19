package com.example.demo;

public class ClaimManager {

    // Reporting service query from the front end
    // graphql stitching

    // claims list endpoint
    // REST, accepts manager UUID, header has JWT
    // validate JWT, and extract tenant information
    // validate claim UUID belong to tenant (id service)
    // call dblink (stored proc) with UUID, returns claims_list data

}
