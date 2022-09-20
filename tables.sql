create table user_data (
    id uuid not null default gen_random_uuid(),
    name varchar(255) not null,
    surname varchar(255) not null,
    login varchar(255) not null unique,
    password varchar(255) not null,
    primary key(id)
);

create table customer (
    id uuid not null default gen_random_uuid(),
    address text not null,
    user_data_id uuid not null unique references user_data(id),
    primary key(id)
);

create table delivery (
    id uuid not null default gen_random_uuid(),
    user_data_id uuid not null unique references user_data(id),
    primary key(id)
);

create table user_order(
    id uuid not null default gen_random_uuid(),
    customer_id uuid not null references customer(id),
    delivery_id uuid not null references delivery(id),
    order_time timestamp not null,
    primary key(id)
);

create table category (
    id uuid not null default gen_random_uuid(),
    name varchar(255) not null unique,
    primary key(id)
);

create table recipe (
    id uuid not null default gen_random_uuid(),
    descr text not null,
    primary key(id)
);

create table foodstuff (
    id uuid not null default gen_random_uuid(),
    name varchar(255) not null,
    calories int not null,
    primary key(id)
);

create table food_in_recipe (
    recipe_id uuid not null references recipe(id),
    foodstuff_id uuid not null references foodstuff(id),
    weight int not null,
    primary key(recipe_id, foodstuff_id)
);

create table restaurant (
    id uuid not null default gen_random_uuid(),
    name varchar(255) not null,
    rating int not null, -- check (rating > 0 & rating < 6)
    primary key(id)
);

create table dish (
    id uuid not null default gen_random_uuid(),
    name varchar(255) not null,
    restaurant_id uuid not null references restaurant(id),
    recipe_id uuid not null references recipe(id),
    primary key(id)
);

create table category_of_dish (
    dish_id uuid not null references dish(id),
    category_id uuid not null references category(id),
    primary key(dish_id, category_id)
);


