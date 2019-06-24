PGDMP                         w            halodb    9.4.22    9.4.22 +    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    16881    halodb    DATABASE     �   CREATE DATABASE halodb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE halodb;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            �           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                        3079    11855    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    17022    confirm_token    TABLE     �   CREATE TABLE public.confirm_token (
    id bigint NOT NULL,
    confirm_token character varying(255),
    user_id bigint NOT NULL
);
 !   DROP TABLE public.confirm_token;
       public         postgres    false    6            �            1259    17020    confirm_token_id_seq    SEQUENCE     }   CREATE SEQUENCE public.confirm_token_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.confirm_token_id_seq;
       public       postgres    false    6    179                        0    0    confirm_token_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.confirm_token_id_seq OWNED BY public.confirm_token.id;
            public       postgres    false    178            �            1259    17034    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       postgres    false    6            �            1259    17036 
   my_seq_gen    SEQUENCE     s   CREATE SEQUENCE public.my_seq_gen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.my_seq_gen;
       public       postgres    false    6            �            1259    16995    role    TABLE     c   CREATE TABLE public.role (
    id bigint NOT NULL,
    role_name character varying(30) NOT NULL
);
    DROP TABLE public.role;
       public         postgres    false    6            �            1259    16993    role_id_seq    SEQUENCE     t   CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.role_id_seq;
       public       postgres    false    176    6                       0    0    role_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;
            public       postgres    false    175            �            1259    17003 	   user_role    TABLE     t   CREATE TABLE public.user_role (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);
    DROP TABLE public.user_role;
       public         postgres    false    6            �            1259    16985    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    user_name character varying(36) NOT NULL,
    encryted_password character varying(128) NOT NULL,
    enabled integer NOT NULL,
    email character varying(255) NOT NULL
);
    DROP TABLE public.users;
       public         postgres    false    6            �            1259    16983    users_id_seq    SEQUENCE     u   CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public       postgres    false    174    6                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
            public       postgres    false    173            o           2604    17025    id    DEFAULT     t   ALTER TABLE ONLY public.confirm_token ALTER COLUMN id SET DEFAULT nextval('public.confirm_token_id_seq'::regclass);
 ?   ALTER TABLE public.confirm_token ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    178    179    179            n           2604    16998    id    DEFAULT     b   ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);
 6   ALTER TABLE public.role ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    176    175    176            m           2604    16988    id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    174    173    174            �          0    17022    confirm_token 
   TABLE DATA                     public       postgres    false    179   �)                  0    0    confirm_token_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.confirm_token_id_seq', 1, true);
            public       postgres    false    178                       0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 36, true);
            public       postgres    false    180                       0    0 
   my_seq_gen    SEQUENCE SET     9   SELECT pg_catalog.setval('public.my_seq_gen', 1, false);
            public       postgres    false    181            �          0    16995    role 
   TABLE DATA                     public       postgres    false    176   �*                  0    0    role_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.role_id_seq', 1, false);
            public       postgres    false    175            �          0    17003 	   user_role 
   TABLE DATA                     public       postgres    false    177   +       �          0    16985    users 
   TABLE DATA                     public       postgres    false    174   +                  0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 7, true);
            public       postgres    false    173            u           2606    17000    app_role_pk 
   CONSTRAINT     N   ALTER TABLE ONLY public.role
    ADD CONSTRAINT app_role_pk PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.role DROP CONSTRAINT app_role_pk;
       public         postgres    false    176    176            w           2606    17002    app_role_uk 
   CONSTRAINT     P   ALTER TABLE ONLY public.role
    ADD CONSTRAINT app_role_uk UNIQUE (role_name);
 :   ALTER TABLE ONLY public.role DROP CONSTRAINT app_role_uk;
       public         postgres    false    176    176            q           2606    16990    app_user_pk 
   CONSTRAINT     O   ALTER TABLE ONLY public.users
    ADD CONSTRAINT app_user_pk PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.users DROP CONSTRAINT app_user_pk;
       public         postgres    false    174    174            s           2606    16992    app_user_uk 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT app_user_uk UNIQUE (user_name);
 ;   ALTER TABLE ONLY public.users DROP CONSTRAINT app_user_uk;
       public         postgres    false    174    174            }           2606    17027    id_pk 
   CONSTRAINT     Q   ALTER TABLE ONLY public.confirm_token
    ADD CONSTRAINT id_pk PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.confirm_token DROP CONSTRAINT id_pk;
       public         postgres    false    179    179            y           2606    17007    user_role_pk 
   CONSTRAINT     T   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pk PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_pk;
       public         postgres    false    177    177            {           2606    17009    user_role_uk 
   CONSTRAINT     ]   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_uk UNIQUE (user_id, role_id);
 @   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_uk;
       public         postgres    false    177    177    177            �           2606    17028 
   user_id_fk    FK CONSTRAINT     w   ALTER TABLE ONLY public.confirm_token
    ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES public.users(id);
 B   ALTER TABLE ONLY public.confirm_token DROP CONSTRAINT user_id_fk;
       public       postgres    false    174    179    1905            ~           2606    17010    user_role_fk1    FK CONSTRAINT     v   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_fk1 FOREIGN KEY (user_id) REFERENCES public.users(id);
 A   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_fk1;
       public       postgres    false    174    1905    177                       2606    17015    user_role_fk2    FK CONSTRAINT     u   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_fk2 FOREIGN KEY (role_id) REFERENCES public.role(id);
 A   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_fk2;
       public       postgres    false    176    1909    177            �   �   x���A�@�����9*,��h)�:x�R�
��RiX����@��:���S��8�T��D���ݦ��[���g�#E���wҴ���}L��k���\�o�Ӕ�UBHcW��
���L�=�[As���e�4š���mʲ��m���S�P�������B<      �   U   x���v
Q���W((M��L�+��IU��L�Q ���sS5�}B]�4uԃ�}\�]|=��5��<I4�fB(P� .. ��&�      �   
   x���          �     x���Ak�0���lA�Ѧ1��zFk�k�J��b����G���wz�!���|�ۼ�!��_���*�^�N�LU��ЊFF ۲����pZ�������i���������,� �EE�BӒ$]�3��6��`�z���<5�І� ����EQ�K�8��G���<̱�s\M�-�#`�Ð�X0r᎒L��K�:K�P�(�QV�Xl!`Fw��c>���cHF�˦asS��\��Bm!hF�K~N�[����7�$~ B�	,     