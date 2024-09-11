CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE pw_company (
    company_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);