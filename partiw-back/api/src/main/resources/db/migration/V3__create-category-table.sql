CREATE TABLE pw_category (
    category_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    company_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    value_max INT NOT NULL,
    co_participation INT,

    FOREIGN KEY (company_id) REFERENCES pw_company(company_id)
);