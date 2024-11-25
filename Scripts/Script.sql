CREATE TABLE exemplo (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(100)
);