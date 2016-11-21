
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
