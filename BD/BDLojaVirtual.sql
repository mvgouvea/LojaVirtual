create table cliente(
	cli_id	serial primary key,
	cli_nome	varchar(60),
	cli_cpf	char(14),
	cli_rg	varchar(20),
	cli_data_nasc	date,
	cli_rua	varchar(60),
	cli_bairro	varchar(30),
	cli_cidade	varchar(30),
	cli_uf	char(2),
	cli_cep	integer,
	cli_email	varchar(40),
	cli_senha	varchar(32)
);

create table fone (
	fon_id	serial	primary key,
	cli_id	integer,
	fon_numero	varchar(20),
	fon_descricao	varchar(30),
	constraint rel_cliente_fone foreign key (cli_id) references cliente (cli_id)
);