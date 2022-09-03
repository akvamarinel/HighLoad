pups is dead

```mermaid
    classDiagram
    User "*" <--> "*" Role

    User "1" --> "*" Artist
    Artist "1" --> "*" Release
    Release "1" --> "*" Track
    Genre "*" <--> "*" Release
```
