# Лабораторная работа № 1

## Студенты:
- Карасёва Мария
- Назаренко Арсений

## Группа:
P34312

## Архитектура БД:
### Доставка еды
```mermaid
	classDiagram
	User "1" <--> "*" Order
	Order "*" <--> "*" Dish
	Dish "*" <--> "*" Recipe 
	Recipe "*" <--> "*" Category
	Recipe "*" <--> "*" Foodstuff
```
> Пользователь может иметь несколько заказов. Каждый заказ включает в себя блюда, одно блюдо может быть включено в несколько заказов. Блюдо может относиться к нескольким категориям, разные блюда могут входить в одну и ту же категорию. Ресторан содержит в своем меню разные блюда, каждое из которых имеет свой рецепт. В состав рецепта входит список продуктов. Разные составы могут содержать одинаковые продукты. Курьер отвественен за доставку нескольких разных заказов.
> Каждый пользователь может иметь несколько рецептов, рецепт может относиться к нескольким категориям (блюда без глютена, постные, веганские, диетические и т.д.), между рецептом и продуктом питания отношение "многие ко многим" с дополнительным полем "количество в граммах". Каждый рецепт будет иметь поле "статус" c одним из значений: принят, отклонен, в обработке.
