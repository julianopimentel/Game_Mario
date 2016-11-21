
*/
*MYSQL 21/06/2016 CREATE BY JULIANO P.
*/


*/
*CRIAR DB
*/
CREATE DATABASE IF NOT EXISTS `apsgame`
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


*/
*SELECIONAR O DB
*/
USE `apsgame`;


*/
*CRIAR TABELA
*/
DROP TABLE IF EXISTS `recordes`;
CREATE TABLE IF NOT EXISTS `recordes`(
  `id` INT UNSIGNED NOT NULL AUTO_INCRIMENT,
  `nome` VARCHAR(20) COLLATE utf8_general_ci,
  `pontuacao` INT UNSIGNED NOT NULL,
PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCRIMENT=1;


*/
*SELECIONAR A TABELA
*/
SELECT * 
  FROM recordes
  where id=?
  ORDER BY id ASC;
  
  
*/
*INSERIR NA TABELA
*/
INSERT INT (id, nome, recordes)
  VALUES(NULL, ?, ?);
  
  
*/
*ATUALIZAR A TABELA
*/
UPDATE recordes
  SET nome=`?`, pontuacao=`?`
  WHERE id=`?`;
  
  
*/
*DELETAR A TABELA
*/
DELETE FROM recordes
  WHERE id=`?`;
