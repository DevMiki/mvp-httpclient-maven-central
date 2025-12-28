# MavenAPI

Small Java/Maven console app that searches **Maven Central** for a library and prints matching artifacts.

## What it does

- Prompts you for a `groupId` and an `artifactId` (for example `com.fasterxml.jackson.core` / `jackson-databind`).
- Calls Maven Central Search API (`search.maven.org`) with those values.
- Parses the JSON response with Jackson and prints the returned artifact IDs.

This is useful as a simple example of “searching Maven Central for dependencies” and mapping the response into Java objects.

## How to run

Requires Java 11+ and Maven.

1. Build:
   - `mvn package`
2. Run the main class:
   - `mvn -q exec:java`

To run a different main class, override the property:
- `mvn -q exec:java -Dexec.mainClass=it.core.SimplePostTest`

## Project layout

- `src/main/java/it/core/MavenAPI.java`: main program (Maven Central search).
- `src/main/java/it/core/EntryToQueryParam.java`: URL-encodes query parameters.
- `src/main/java/it/mappings/*`: POJOs used to deserialize the JSON response.
- `src/main/java/it/core/SimplePostTest.java`: extra demo (POST + JSON mapping).
- `src/main/java/it/core/WriteOnFile.java`: extra demo (download a page to a file; path is hardcoded).

## Notes

- Maven is configured to use a project-local repository under `.m2/` (see `.mvn/maven.config`) so builds don’t depend on a global `~/.m2` cache.
