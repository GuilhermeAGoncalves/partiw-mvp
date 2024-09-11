CREATE TABLE pw_contribuitor (
    cpf VARCHAR(255) PRIMARY KEY,
    company_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phonenumber varchar(255) NOT NULL,
    hired BOOLEAN NOT NULL,
    dt_birth TIMESTAMP NOT NULL,
    role VARCHAR(255) NOT NULL,
    dt_admission TIMESTAMP NOT NULL,
    dt_init_vacation TIMESTAMP NOT NULL,
    category_id UUID NOT NULL,

    FOREIGN KEY (company_id) REFERENCES pw_company(company_id),
    FOREIGN KEY (category_id) REFERENCES pw_category(category_id)
);