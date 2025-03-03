CREATE TABLE Login(
	UserId INT PRIMARY KEY,
	Email VARCHAR(100) UNIQUE,
	Password VARCHAR(100),
	UserType VARCHAR(16),
	CONSTRAINT chk_usertype CHECK (UserType IN ('SalesPerson', 'InventoryOfficer', 'IS_Manager'))
);
CREATE TABLE SalesPerson(
	UserId INT,
	Name VARCHAR(100),
	Email VARCHAR(100) UNIQUE,
	DateOfBirth DATE
);
CREATE TABLE InventoryOfficer(
	UserId INT,
	Name VARCHAR(100),
	Email VARCHAR(100) UNIQUE,
	DateOfBirth DATE
);
CREATE TABLE IS_Manager(
	UserId INT,
	Name VARCHAR(100),
	Email VARCHAR(100) UNIQUE,
	DateOfBirth DATE
);
CREATE TABLE TextileFactory(
	FactoryId INT AUTO_INCREMENT PRIMARY KEY,
	Location VARCHAR(200),
	Name VARCHAR(100)
);
CREATE TABLE Transport(
	TransportId INT PRIMARY KEY AUTO_INCREMENT,
	VehicleType VARCHAR(50),
	Price DECIMAL (4,2)
);
CREATE TABLE Item(
	ItemId INT PRIMARY KEY,
    ItemName VARCHAR(100),
    CostPerUnit DECIMAL (10,2),
    Colours VARCHAR(200),
    ItemType VARCHAR(40),
    Precautions VARCHAR(1000),
    Texture VARCHAR(100),
    Origin INT,
    Lifespan INT,
	QtyInStock INT
);
CREATE TABLE Natural_fiber(
	NaturalId INT PRIMARY KEY,
	NaturalName VARCHAR(100),
	Source VARCHAR(40),
	Instructions VARCHAR(1000),
	Lifespan INT,
	QtyInStock INT
);
CREATE TABLE Man_made_fiber(
	ManMadeId INT PRIMARY KEY,
	ManMadeName VARCHAR(100),
	Properties VARCHAR(1000),
	Lifespan INT,
	QtyInStock INT
);
CREATE TABLE Mixed(
	MixedId INT PRIMARY KEY,
	PercentNatural DECIMAL(4,2),
	PercentManMade DECIMAL(4,2),
	MixedName VARCHAR(100),
	Lifespan INT,
	QtyInStock INT
);
CREATE TABLE MixedNatural(
	MixedId INT,
	NaturalId INT
);
CREATE TABLE MixedManMade(
	MixedId INT,
	ManMadeId INT
);
CREATE TABLE Orders(
	OrderId INT AUTO_INCREMENT PRIMARY KEY ,
	CustId INT,
	SubTotal DECIMAL (20,2),
	OrderDate DATE,
	DeliveryDate DATE,
	Transportation INT,
	Status VARCHAR(9)
);
CREATE TABLE Order_Details(
	OrderId INT,
	ItemId INT,
	ItemName VARCHAR(40),
	CostPerUnit DECIMAL (10,2),
	Quantity INT,
	TotalCost DECIMAL (20,2)
);
CREATE TABLE Customer(
	CustId INT AUTO_INCREMENT PRIMARY KEY,
	CustName VARCHAR(100),
	PaymentMethod VARCHAR (100),
	DateOfBirth DATE,
	PhoneNumber VARCHAR(8),
	CustAddress VARCHAR(100)
);
CREATE TABLE Report(
	ReportId INT PRIMARY KEY,
	ReportDate DATE,
	Earnings DECIMAL(20,2)
);
