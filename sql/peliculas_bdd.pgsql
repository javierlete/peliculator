--
-- PostgreSQL database dump
--

-- Dumped from database version 10.15 (Ubuntu 10.15-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.15 (Ubuntu 10.15-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: peliculas_bdd; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA peliculas_bdd;


ALTER SCHEMA peliculas_bdd OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: generos; Type: TABLE; Schema: peliculas_bdd; Owner: postgres
--

CREATE TABLE peliculas_bdd.generos (
    id bigint NOT NULL,
    nombre character varying(45) NOT NULL,
    descripcion text,
    padre_id bigint
);


ALTER TABLE peliculas_bdd.generos OWNER TO postgres;

--
-- Name: generos_id_seq; Type: SEQUENCE; Schema: peliculas_bdd; Owner: postgres
--

CREATE SEQUENCE peliculas_bdd.generos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE peliculas_bdd.generos_id_seq OWNER TO postgres;

--
-- Name: generos_id_seq; Type: SEQUENCE OWNED BY; Schema: peliculas_bdd; Owner: postgres
--

ALTER SEQUENCE peliculas_bdd.generos_id_seq OWNED BY peliculas_bdd.generos.id;


--
-- Name: peliculas; Type: TABLE; Schema: peliculas_bdd; Owner: postgres
--

CREATE TABLE peliculas_bdd.peliculas (
    id bigint NOT NULL,
    titulo character varying(255) NOT NULL,
    fecha_estreno date,
    id_genero bigint
);


ALTER TABLE peliculas_bdd.peliculas OWNER TO postgres;

--
-- Name: peliculas_id_seq; Type: SEQUENCE; Schema: peliculas_bdd; Owner: postgres
--

CREATE SEQUENCE peliculas_bdd.peliculas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE peliculas_bdd.peliculas_id_seq OWNER TO postgres;

--
-- Name: peliculas_id_seq; Type: SEQUENCE OWNED BY; Schema: peliculas_bdd; Owner: postgres
--

ALTER SEQUENCE peliculas_bdd.peliculas_id_seq OWNED BY peliculas_bdd.peliculas.id;


--
-- Name: generos id; Type: DEFAULT; Schema: peliculas_bdd; Owner: postgres
--

ALTER TABLE ONLY peliculas_bdd.generos ALTER COLUMN id SET DEFAULT nextval('peliculas_bdd.generos_id_seq'::regclass);


--
-- Name: peliculas id; Type: DEFAULT; Schema: peliculas_bdd; Owner: postgres
--

ALTER TABLE ONLY peliculas_bdd.peliculas ALTER COLUMN id SET DEFAULT nextval('peliculas_bdd.peliculas_id_seq'::regclass);


--
-- Data for Name: generos; Type: TABLE DATA; Schema: peliculas_bdd; Owner: postgres
--

COPY peliculas_bdd.generos (id, nombre, descripcion, padre_id) FROM stdin;
1	Acción	Se mueven	\N
2	Comedia	Te ríes	\N
3	Marvel	\N	1
4	DC	\N	1
5	Sitcom	\N	2
6	Fácil	\N	2
\.


--
-- Data for Name: peliculas; Type: TABLE DATA; Schema: peliculas_bdd; Owner: postgres
--

COPY peliculas_bdd.peliculas (id, titulo, fecha_estreno, id_genero) FROM stdin;
1	Superman	1991-01-01	2
3	El Mundo de Wayne 😁	1997-07-08	2
7	Matrix	2006-01-01	1
9	Curso en la universidad	2020-12-01	2
\.


--
-- Name: generos_id_seq; Type: SEQUENCE SET; Schema: peliculas_bdd; Owner: postgres
--

SELECT pg_catalog.setval('peliculas_bdd.generos_id_seq', 6, true);


--
-- Name: peliculas_id_seq; Type: SEQUENCE SET; Schema: peliculas_bdd; Owner: postgres
--

SELECT pg_catalog.setval('peliculas_bdd.peliculas_id_seq', 9, true);


--
-- Name: generos idx_16427_primary; Type: CONSTRAINT; Schema: peliculas_bdd; Owner: postgres
--

ALTER TABLE ONLY peliculas_bdd.generos
    ADD CONSTRAINT idx_16427_primary PRIMARY KEY (id);


--
-- Name: peliculas idx_16436_primary; Type: CONSTRAINT; Schema: peliculas_bdd; Owner: postgres
--

ALTER TABLE ONLY peliculas_bdd.peliculas
    ADD CONSTRAINT idx_16436_primary PRIMARY KEY (id);


--
-- Name: idx_16427_fk_generos_generos1_idx; Type: INDEX; Schema: peliculas_bdd; Owner: postgres
--

CREATE INDEX idx_16427_fk_generos_generos1_idx ON peliculas_bdd.generos USING btree (padre_id);


--
-- Name: idx_16427_nombre_unique; Type: INDEX; Schema: peliculas_bdd; Owner: postgres
--

CREATE UNIQUE INDEX idx_16427_nombre_unique ON peliculas_bdd.generos USING btree (nombre);


--
-- Name: idx_16436_fk_peliculas_generos_idx; Type: INDEX; Schema: peliculas_bdd; Owner: postgres
--

CREATE INDEX idx_16436_fk_peliculas_generos_idx ON peliculas_bdd.peliculas USING btree (id_genero);


--
-- Name: generos fk_generos_generos1; Type: FK CONSTRAINT; Schema: peliculas_bdd; Owner: postgres
--

ALTER TABLE ONLY peliculas_bdd.generos
    ADD CONSTRAINT fk_generos_generos1 FOREIGN KEY (padre_id) REFERENCES peliculas_bdd.generos(id);


--
-- Name: peliculas fk_peliculas_generos; Type: FK CONSTRAINT; Schema: peliculas_bdd; Owner: postgres
--

ALTER TABLE ONLY peliculas_bdd.peliculas
    ADD CONSTRAINT fk_peliculas_generos FOREIGN KEY (id_genero) REFERENCES peliculas_bdd.generos(id);


--
-- PostgreSQL database dump complete
--

