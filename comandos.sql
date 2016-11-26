
*/
*MYSQL 21/06/2016 CREATE BY JULIANO P.
*/


*/
*CRIAR DB
*/
CREATE DATABASE IF NOT EXISTS `jma`
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


*/
*SELECIONAR O DB
*/
USE `jma`;


*/
*CRIAR TABELA
*/
DROP TABLE IF EXISTS `recordes`;
CREATE TABLE IF NOT EXISTS `recordes`(
  `id` INT UNSIGNED NOT NULL AUTO_INCRIMENT,
  `jogador` VARCHAR(20) COLLATE utf8_general_ci,
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
INSERT INT (id, jogador, pontuacao)
  VALUES(NULL, ?, ?);
  
  
*/
*ATUALIZAR A TABELA
*/
UPDATE recordes
  SET jogador=`?`, pontuacao=`?`
  WHERE id=`?`;
  
  
*/
*DELETAR A TABELA
*/
DELETE FROM recordes
  WHERE id=`?`;
