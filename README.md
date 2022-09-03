# Лабораторная работа № 1

## Студенты:
- Карасёва Мария
- Назаренко Арсений

## Группа:
P34312

### Форум рецептов
```mermaid
	classDiagram
	User "*" <--> "*" Role

	User "1" <--> "*" Recipe
	Recipe "1" <--> "1" Dish
	Dish "*" <--> "*" Foodstuff
```
