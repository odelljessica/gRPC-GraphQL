CREATE TABLE wiringInstructions(
intWiringInstructionsID Integer,
vchWiringName varchar(50),
vchBankName varchar(50),
chrABANumber varchar(50),
vchSwift varchar(50),
vchForAccountOf varchar(50),
vchAccountNumber varchar(50),
vchInFavourOf varchar(50),
vchInFavourOfAccountNumber varchar(50),
intObjectID Integer,
PRIMARY KEY (intWiringInstructionsID)
);
CREATE TABLE products (
intProductID Integer,
varDescription varchar(50),
intValue varchar(50),
PRIMARY KEY (intProductID)
);
CREATE TABLE bank(
intObjectID Integer,
vchCommonName varchar(50),
PRIMARY KEY (intObjectID)
);
CREATE TABLE productWiringInstructions(
intProductID Integer,
intWiringInstructionsID varchar(50)
);
INSERT INTO wiringInstructions VALUES
(1, 'Test Wiring Name', 'Test Bank Name', 'Test ABA Number', 'Test Swift', 'Test Account',
'Test Account Number', 'Test In Favour Of', 'Test In Favour Of Account Num', 123),
(2, 'Test Wiring Name 2', 'Test Bank Name 2', 'Test ABA Number 2', 'Test Swift 2','Test Account 2',
'Test Account Number 2', 'Test In Favour Of 2', 'Test In Favour Of Account Num 2', 345);
INSERT INTO products VALUES
(1, 'Description', 100),
(2, 'Description', 200);
INSERT INTO bank VALUES
(123, 'Bank Name'),
(345, 'Bank Name 2');
INSERT INTO productWiringInstructions values
(1, 1),
(2,2);