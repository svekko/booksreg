CREATE EXTENSION IF NOT EXISTS btree_gist;

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    subtitle VARCHAR(256),
    number_of_pages INTEGER NOT NULL,

    CONSTRAINT unique_book_title EXCLUDE USING gist (trim(upper(title)) WITH =)
);
