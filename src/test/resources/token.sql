CREATE TABLE IF NOT EXISTS public.users (
    id bigint NOT NULL,
    password character varying(50),
    token character varying(120),
    username character varying(20)
);

ALTER TABLE public.users OWNER TO f1_user;

INSERT INTO public.users VALUES (999999, 'PASSWORD', '2176d2c3-89c8-4c3e-acab-253f9b32FFFF', 'TEST_USER') ON CONFLICT DO NOTHING;