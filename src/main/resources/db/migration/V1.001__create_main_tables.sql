create table if not exists tb_user
(
    user_id  UUID primary key not null,
    name     varchar(50)      not null,
    email    varchar(100)     not null,
    username varchar(30)      not null
);

create table if not exists tb_product
(
    product_id   UUID primary key not null,
    name         varchar(50)      not null,
    description  TEXT             not null,
    price        decimal(10, 2)   not null,
    score        decimal(2, 1)    not null default 0.0,
    review_count smallint         not null default 0
);

create table if not exists tb_review
(
    review_id   UUID primary key not null,
    description TEXT             not null,
    score       decimal(2, 1)    not null,
    product_cod UUID             not null,
    user_cod    UUID             not null,
    CONSTRAINT fk_product_review
        FOREIGN KEY (product_cod)
            REFERENCES tb_product (product_id),
    CONSTRAINT fk_user_review
        FOREIGN KEY (user_cod)
            REFERENCES tb_user (user_id)
);

create table if not exists tb_order
(
    order_id    UUID primary key not null,
    total_price decimal(10, 2)   not null default 0.0,
    user_cod    UUID             not null,
    CONSTRAINT fk_user_order
        FOREIGN KEY (user_cod)
            REFERENCES tb_user (user_id)
);

create table if not exists tb_product_order
(
    product_order_id UUID primary key not null,
    order_cod        UUID             not null,
    product_cod      UUID             not null,
    CONSTRAINT fk_order_product_order
        FOREIGN KEY (order_cod)
            REFERENCES tb_order (order_id),
    CONSTRAINT fk_product_product_order
        FOREIGN KEY (product_cod)
            REFERENCES tb_product (product_id),
    CONSTRAINT unique_order_product
        UNIQUE (order_cod, product_cod) -- Garante que um produto não seja repetido em uma ordem
);
