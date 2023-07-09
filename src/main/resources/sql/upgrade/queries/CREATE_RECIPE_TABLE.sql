CREATE TABLE IF NOT EXISTS recipe (
    id NUMERIC(17) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(300),
    recipe_type VARCHAR(3) NOT NULL,
    data VARCHAR(4000),
    preview_id VARCHAR(128)
);

CREATE SEQUENCE IF NOT EXISTS recipe_seq;

CREATE INDEX idx__rp_recipe_type ON recipe (
    recipe_type
);

ALTER TABLE recipe ADD COLUMN preview_id VARCHAR(128);
select * from recipe;