INSERT INTO "PUBLIC"."USER" VALUES
(1, 'teste@email.com', STRINGDECODE('Usu\u00e1rio teste'), '$2a$10$rhpba1EAsnuzNq77UpnkreU2y0ppDwokfWdDSOz1GdbfBGPc9/iMK');

INSERT INTO "PUBLIC"."TASK" VALUES
(1, STRINGDECODE('Gerar relat\u00f3rios'), TRUE, 2, 1),
(2, 'Conferir o estoque', FALSE, 0, 1);