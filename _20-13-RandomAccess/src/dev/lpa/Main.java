package dev.lpa;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final Map<Long, Long> indexesIds = new LinkedHashMap<>();
    private static int recordsInFile = 0;

    public static void main(String[] args) {

        BuildStudentData.build("studentData");
    }
}
