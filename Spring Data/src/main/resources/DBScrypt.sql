CREATE TABLE public.userimpl (
	id int8 NOT NULL,
	email varchar(255) NULL,
	name varchar(255) NULL,
	useraccountid int8 NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (useraccountid) REFERENCES public.useraccountimpl(accountid)
);

CREATE TABLE public.useraccountimpl (
	accountid int8 NOT NULL,
	balance numeric(19, 2) NULL,
	PRIMARY KEY (accountid)
);

CREATE TABLE public.eventimpl (
	id int8 NOT NULL,
	"date" date NULL,
	ticketprice numeric(19, 2) NULL,
	title varchar(255) NULL,
	"event" int8 NULL,
	PRIMARY KEY (id),
	FOREIGN KEY ("event") REFERENCES public.userimpl(id)
);

CREATE TABLE public.ticketimpl (
    id int8 NOT NULL,
    category varchar(255) NULL,
    place int8 NULL,
    "event" int8 NULL,
    "user" int8 NULL,
    PRIMARY KEY (id),
    FOREIGN KEY ("event") REFERENCES public.eventimpl(id),
    FOREIGN KEY ("user") REFERENCES public.userimpl(id)
);

INSERT INTO public.userimpl VALUES (1, 'test@mail.ru', 'petr', 1);
INSERT INTO public.useraccountimpl VALUES (1, 0);
INSERT INTO public.eventimpl VALUES (1, '2021-07-13', 100, 'buy', 1);
INSERT INTO public.ticketimpl VALUES (1, 'BAR', 1, 1, 1);

