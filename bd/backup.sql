
CREATE DATABASE pruebadw WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';


ALTER DATABASE pruebadw OWNER TO usrprueba;





--
-- TOC entry 203 (class 1259 OID 16420)
-- Name: pasajeros; Type: TABLE; Schema: public; Owner: usrprueba
--

CREATE TABLE public.pasajeros (
    id bigint NOT NULL,
    tipdocumento smallint NOT NULL,
    identificacion bigint NOT NULL,
    pnombre character varying(80) NOT NULL,
    snombre character varying(80),
    papellido character varying(80) NOT NULL,
    sapellido character varying(80),
    email character varying(200) NOT NULL,
    ncelular bigint
);


ALTER TABLE public.pasajeros OWNER TO usrprueba;

--
-- TOC entry 202 (class 1259 OID 16418)
-- Name: pasajeros_id_seq; Type: SEQUENCE; Schema: public; Owner: usrprueba
--

CREATE SEQUENCE public.pasajeros_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pasajeros_id_seq OWNER TO usrprueba;

--
-- TOC entry 3265 (class 0 OID 0)
-- Dependencies: 202
-- Name: pasajeros_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: usrprueba
--

ALTER SEQUENCE public.pasajeros_id_seq OWNED BY public.pasajeros.id;


--
-- TOC entry 201 (class 1259 OID 16409)
-- Name: usuariosrest; Type: TABLE; Schema: public; Owner: usrprueba
--

CREATE TABLE public.usuariosrest (
    id bigint NOT NULL,
    activo boolean,
    email character varying(255),
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.usuariosrest OWNER TO usrprueba;

--
-- TOC entry 200 (class 1259 OID 16407)
-- Name: usuariosrest_id_seq; Type: SEQUENCE; Schema: public; Owner: usrprueba
--

CREATE SEQUENCE public.usuariosrest_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuariosrest_id_seq OWNER TO usrprueba;

--
-- TOC entry 3266 (class 0 OID 0)
-- Dependencies: 200
-- Name: usuariosrest_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: usrprueba
--

ALTER SEQUENCE public.usuariosrest_id_seq OWNED BY public.usuariosrest.id;


--
-- TOC entry 3124 (class 2604 OID 16423)
-- Name: pasajeros id; Type: DEFAULT; Schema: public; Owner: usrprueba
--

ALTER TABLE ONLY public.pasajeros ALTER COLUMN id SET DEFAULT nextval('public.pasajeros_id_seq'::regclass);


--
-- TOC entry 3123 (class 2604 OID 16412)
-- Name: usuariosrest id; Type: DEFAULT; Schema: public; Owner: usrprueba
--

ALTER TABLE ONLY public.usuariosrest ALTER COLUMN id SET DEFAULT nextval('public.usuariosrest_id_seq'::regclass);


--
-- TOC entry 3128 (class 2606 OID 16428)
-- Name: pasajeros pasajeros_pkey; Type: CONSTRAINT; Schema: public; Owner: usrprueba
--

ALTER TABLE ONLY public.pasajeros
    ADD CONSTRAINT pasajeros_pkey PRIMARY KEY (id);


--
-- TOC entry 3126 (class 2606 OID 16417)
-- Name: usuariosrest usuariosrest_pkey; Type: CONSTRAINT; Schema: public; Owner: usrprueba
--

ALTER TABLE ONLY public.usuariosrest
    ADD CONSTRAINT usuariosrest_pkey PRIMARY KEY (id);


-- Completed on 2021-04-13 18:11:09 -05

--
-- PostgreSQL database dump complete
--





INSERT INTO public.usuariosrest (activo, email, password, username) VALUES ( true, NULL, '$2a$10$1dCKuQoQqbBNCK.Rb8XQSemwqdHdVAcCTb1kUQLg2key/4VX./TvS', 'admin');
