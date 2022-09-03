<<<<<<< HEAD
# Лабораторная работа № 1

## Студенты:
- Карасёва Мария
- Назаренко Арсений

## Группа:
P34312

### Форум рецептов
```mermarid
	classDiagram
	User "*" <--> "*" Role

	User "1" <--> "*" Recipe
	Recipe "1" <--> "1" Dish
	Dish "*" <--> "*" Foodstuff
=======
pups is dead

```mermaid
    classDiagram
    User "*" <--> "*" Role

    User "1" --> "*" Artist
    Artist "1" --> "*" Release
    Release "1" --> "*" Track
    Genre "*" <--> "*" Release
```
>>>>>>> 3c0858f2e744ccc398905901ab7cd1f0de72a825
