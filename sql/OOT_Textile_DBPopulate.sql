/* --- Populate Login and related user tables --- */

/* Insert into Login */
INSERT INTO Login (UserId, Email, Password, UserType) VALUES
  (1, 'sales1@example.com', 'pass1', 'SalesPerson'),
  (2, 'sales2@example.com', 'pass2', 'SalesPerson'),
  (3, 'inv1@example.com', 'pass3', 'InventoryOfficer'),
  (4, 'inv2@example.com', 'pass4', 'InventoryOfficer'),
  (5, 'manager1@example.com', 'pass5', 'IS_Manager');

/* Insert into SalesPerson (UserId must match Login where UserType = 'SalesPerson') */
INSERT INTO SalesPerson (UserId, Name, Email, DateOfBirth) VALUES
  (1, 'Alice Johnson', 'sales1@example.com', '1985-06-15'),
  (2, 'Bob Smith', 'sales2@example.com', '1990-09-22');

/* Insert into InventoryOfficer (UserId must match Login where UserType = 'InventoryOfficer') */
INSERT INTO InventoryOfficer (UserId, Name, Email, DateOfBirth) VALUES
  (3, 'Carol White', 'inv1@example.com', '1982-03-10'),
  (4, 'David Brown', 'inv2@example.com', '1978-11-05');

/* Insert into IS_Manager (UserId must match Login where UserType = 'IS_Manager') */
INSERT INTO IS_Manager (UserId, Name, Email, DateOfBirth) VALUES
  (5, 'Evelyn Black', 'manager1@example.com', '1975-01-30');


/* --- Populate TextileFactory --- */
INSERT INTO TextileFactory (FactoryId, Location, Name) VALUES
  (1, 'New York', 'NY Textiles'),
  (2, 'Los Angeles', 'LA Fabrics'),
  (3, 'Chicago', 'Chicago Textiles'),
  (4, 'Houston', 'Houston Fabrics'),
  (5, 'Miami', 'Miami Textiles');


/* --- Populate Transport --- */
INSERT INTO Transport (TransportId, VehicleType, Price) VALUES
  (1, 'Truck', 150.00),
  (2, 'Van', 100.00),
  (3, 'Ship', 200.00),
  (4, 'Train', 180.00),
  (5, 'Air Freight', 300.00);


/* --- Populate Item --- */
/* Inserting 15 items:
   IDs 1–5: Natural fiber items
   IDs 6–10: Man-made fiber items
   IDs 11–15: Mixed fiber items */
INSERT INTO Item (ItemId, ItemName, CostPerUnit, Colours, ItemType, Precautions, Texture, Lifespan, QtyInStock) VALUES
  -- Natural fiber items
  (1, 'Cotton Fiber', 2.50, 'White, Blue', 'Natural', 'Wash gently', 'Soft', 24, 100),
  (2, 'Wool Fiber', 3.75, 'Grey, Brown', 'Natural', 'Dry clean only', 'Coarse', 36, 80),
  (3, 'Silk Fiber', 5.00, 'Red, Gold', 'Natural', 'Hand wash', 'Smooth', 48, 60),
  (4, 'Linen Fiber', 4.00, 'Beige, Blue', 'Natural', 'Do not bleach', 'Crisp', 30, 50),
  (5, 'Hemp Fiber', 3.00, 'Green, Brown', 'Natural', 'Avoid moisture', 'Rough', 40, 70),
  -- Man-made fiber items
  (6, 'Polyester Fiber', 1.50, 'Various', 'Man-made', 'Standard care', 'Smooth', 60, 200),
  (7, 'Nylon Fiber', 1.80, 'Black, White', 'Man-made', 'Avoid high heat', 'Slick', 55, 150),
  (8, 'Acrylic Fiber', 1.60, 'Various', 'Man-made', 'Do not iron', 'Soft', 50, 130),
  (9, 'Spandex Fiber', 2.00, 'Various', 'Man-made', 'Handle with care', 'Stretchy', 45, 120),
  (10, 'Rayon Fiber', 1.70, 'Mixed', 'Man-made', 'Hand wash', 'Velvety', 52, 110),
  -- Mixed fiber items
  (11, 'Cotton-Poly Blend', 3.00, 'White, Blue', 'Mixed', 'Machine wash', 'Balanced', 36, 90),
  (12, 'Wool-Nylon Blend', 3.50, 'Grey', 'Mixed', 'Dry clean', 'Robust', 40, 70),
  (13, 'Silk-Spandex Blend', 4.50, 'Red', 'Mixed', 'Hand wash', 'Smooth', 42, 60),
  (14, 'Linen-Acrylic Blend', 3.80, 'Beige', 'Mixed', 'Cold wash', 'Crisp', 38, 80),
  (15, 'Hemp-Polyester Blend', 3.20, 'Green', 'Mixed', 'Standard care', 'Rough', 44, 75);


/* --- Populate Natural_fiber --- */
/* Each entry here references a natural fiber item from Item (IDs 1–5) 
   and Origin now corresponds to a valid TextileFactory.FactoryId */
INSERT INTO Natural_fiber (NaturalId, NaturalName, Origin, Source, Instructions, Lifespan, QtyInStock) VALUES
  (1, 'Cotton', 1, 'Plant', 'Organic farming recommended', 24, 100),
  (2, 'Wool', 2, 'Sheep', 'Shearing in spring', 36, 80),
  (3, 'Silk', 3, 'Silkworm', 'Mulberry leaves diet', 48, 60),
  (4, 'Linen', 4, 'Flax', 'Use natural dyes', 30, 50),
  (5, 'Hemp', 5, 'Hemp plant', 'Sustainable processing', 40, 70);


/* --- Populate Man_made_fiber --- */
/* Each entry here references a man-made fiber item from Item (IDs 6–10) */
INSERT INTO Man_made_fiber (ManMadeId, ManMadeName, Properties, Lifespan, QtyInStock) VALUES
  (6, 'Polyester', 'Durable, wrinkle-resistant', 60, 200),
  (7, 'Nylon', 'Strong, elastic', 55, 150),
  (8, 'Acrylic', 'Lightweight, soft', 50, 130),
  (9, 'Spandex', 'Highly stretchable', 45, 120),
  (10, 'Rayon', 'Smooth, absorbent', 52, 110);


/* --- Populate Mixed --- */
/* Each entry here references a mixed fiber item from Item (IDs 11–15)
   PercentNatural and PercentManMade values are now provided as percentages (e.g., 60.00 for 60.00%) */
INSERT INTO Mixed (MixedId, PercentNatural, PercentManMade, MixedName, Lifespan, QtyInStock) VALUES
  (11, 60.00, 40.00, 'Cotton-Poly Blend', 36, 90),
  (12, 55.00, 45.00, 'Wool-Nylon Blend', 40, 70),
  (13, 50.00, 50.00, 'Silk-Spandex Blend', 42, 60),
  (14, 65.00, 35.00, 'Linen-Acrylic Blend', 38, 80),
  (15, 70.00, 30.00, 'Hemp-Polyester Blend', 44, 75);


/* --- Populate MixedNatural (junction table) --- */
/* Link Mixed fiber items (IDs 11–15) with Natural fibers (IDs 1–5) */
INSERT INTO MixedNatural (MixedId, NaturalId) VALUES
  (11, 1),
  (12, 2),
  (13, 3),
  (14, 4),
  (15, 5),
  (11, 2);  -- An extra association


/* --- Populate MixedManMade (junction table) --- */
/* Link Mixed fiber items (IDs 11–15) with Man-made fibers (IDs 6–10) */
INSERT INTO MixedManMade (MixedId, ManMadeId) VALUES
  (11, 6),
  (12, 7),
  (13, 8),
  (14, 9),
  (15, 10),
  (12, 8);  -- An extra association


/* --- Populate Customer --- */
INSERT INTO Customer (CustId, CustName, PaymentMethod, DateOfBirth, PhoneNumber, CustAddress) VALUES
  (1, 'John Doe', 'Credit Card', '1980-04-12', '12345678', '123 Elm St'),
  (2, 'Jane Smith', 'PayPal', '1992-08-23', '23456789', '456 Oak Ave'),
  (3, 'Mike Brown', 'Debit Card', '1975-11-30', '34567890', '789 Pine Rd'),
  (4, 'Emily Davis', 'Cash', '1988-02-14', '45678901', '321 Maple Ln'),
  (5, 'Sarah Wilson', 'Credit Card', '1995-07-07', '56789012', '654 Cedar Blvd');


/* --- Populate Orders --- */
/* Orders now reference a valid Transport record for Transportation */
INSERT INTO Orders (OrderId, CustId, SubTotal, OrderDate, DeliveryDate, Transportation, Status) VALUES
  (1, 1, 150.00, '2025-02-20', '2025-02-25', 1, 'Pending'),
  (2, 2, 200.00, '2025-02-21', '2025-02-26', 2, 'Shipped'),
  (3, 3, 120.00, '2025-02-22', '2025-02-27', 3, 'Delivered'),
  (4, 4, 180.00, '2025-02-23', '2025-02-28', 4, 'Cancelled'),
  (5, 5, 220.00, '2025-02-24', '2025-03-01', 5, 'Pending');


/* --- Populate Order_Details --- */
/* Link orders with items */
INSERT INTO Order_Details (OrderId, ItemId, ItemName, CostPerUnit, Quantity, TotalCost) VALUES
  (1, 1, 'Cotton Fiber', 2.50, 10, 25.00),
  (2, 7, 'Nylon Fiber', 1.80, 20, 36.00),
  (3, 11, 'Cotton-Poly Blend', 3.00, 15, 45.00),
  (4, 3, 'Silk Fiber', 5.00, 5, 25.00),
  (5, 9, 'Spandex Fiber', 2.00, 12, 24.00);


/* --- Populate Report (single entry) --- */
INSERT INTO Report (ReportId, ReportDate, Earnings) VALUES
  (1, '2025-03-01', 10000.00);
