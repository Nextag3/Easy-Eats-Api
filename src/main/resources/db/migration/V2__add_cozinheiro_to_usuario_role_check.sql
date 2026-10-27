-- O papel COZINHEIRO foi adicionado ao enum Role, mas o ddl-auto=update do
-- Hibernate nunca atualiza check constraints: bancos antigos rejeitavam o
-- usuário cozinheiro e a aplicação caía ao subir (DataSeeder).
ALTER TABLE tbusuario DROP CONSTRAINT IF EXISTS tbusuario_role_check;
ALTER TABLE tbusuario ADD CONSTRAINT tbusuario_role_check
    CHECK (role IN ('SUPERADMIN', 'ADMINISTRADOR', 'OPERADOR', 'GARCOM', 'COZINHEIRO'));
