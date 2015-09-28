package com.portablemind.project;

import com.portablemind.rest.api.UrlSpace;

/**
 * Created by Mateusz on 27.09.2015.
 */
public class ProjectUrls implements UrlSpace {

    public static final String PROJECT      = "/project/{projectId}";

    public class Api {
        public static final String PROJECTS = "/api/projects";

        public static final String PROJECT = "/api/project";
        public static final String PROJECT_ID =  "/{projectId}";
        public static final String PROJECT_ID_CARDS = PROJECT_ID + "/cards";
    }
}
