data.sql

-- Inserindo equipes
INSERT INTO equipe (id, nome) VALUES (1, 'Equipe Alpha');
INSERT INTO equipe (id, nome) VALUES (2, 'Equipe Beta');
INSERT INTO equipe (id, nome) VALUES (3, 'Equipe Gamma');

-- Inserindo projetos aprovados e pendentes
INSERT INTO projeto (id, nome, status, fase, equipe_id) VALUES (1, 'Sistema de Vendas', 'APROVADO', 'COMECO', NULL);
INSERT INTO projeto (id, nome, status, fase, equipe_id) VALUES (2, 'App Mobile Delivery', 'APROVADO', 'DESENVOLVIMENTO', NULL);
INSERT INTO projeto (id, nome, status, fase, equipe_id) VALUES (3, 'Dashboard Financeiro', 'PENDENTE', 'COMECO', NULL);
INSERT INTO projeto (id, nome, status, fase, equipe_id) VALUES (4, 'Integração ERP', 'APROVADO', 'COMECO', NULL);
