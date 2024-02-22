-- PRODUCTS
insert into Product (code, name, price_eur, price_usd, description)
values
('SMA54FGA1234567', 'Samsung Galaxy A54 5G 8GB/128GB dual SIM black', 316.99, 341.39, '6,4'''' Super AMOLED, Octa-core, camera: front 32 MP, back 50.0 MP, 12.0 MP, 5.0 MP, 8GB, 128GB, 5000 mAh');

insert into Product (code, name, price_eur, price_usd, description)
values
('SMA52FGA1324659', 'Samsung Galaxy A52 6GB/256GB dual SIM black', 344.95, 320.30, '6,5'''' Super AMOLED, Octa-core, camera: front 32 MP, back 64.0 MP, 12.0 MP, 5.0 MP, 6GB, 256GB, 5400 mAh');

insert into Product (code, name, price_eur, price_usd, description)
values
('XIA12SQMF451846', 'Xiaomi Redmi Note 12S', 199.00, 214.32, '6,43'''', FHD+, AMOLED, 90Hz, MediaTek Helio G96, 8GB RAM, 256GB storage, 5000 mAh');

insert into Product (code, name, price_eur, price_usd, description)
values
('XIA13PRP21153A7', 'Xiaomi Redmi Note 13 Pro+ 5G 8GB/256GB Midnight Black', 478.99, 515.85, '6,67'''' AMOLED screen 120Hz, 8GB+256GB, 5000 mAh,120W Hypercharge, Android 13, Dual SIM, Dolby Atmos, IP68 certificate, Corning Gorilla Glass Victus');

insert into Product (code, name, price_eur, price_usd, description)
values
('IOS13SJ4578FA25', 'Apple iPhone 13 128GB Midnight', 694.00, 747.41, '6,1'''' Super Retina XDR screen, A15 Bionic chip, 128 GB storage, 12 MP main i 12 MP ultra wide, 12 MP front camera, up to 17 hours of video, 5G connection');

insert into Product (code, name, price_eur, price_usd, description)
values
('IOS15PMXS521779', 'Apple iPhone 15 Pro Max 256GB Titanium white', 1515.99, 1632.66, '6,7'''', LTPO Super Retina XDR OLED, 8GB, 256GB, Bionic A17, 48 MP, 4852 mAh, iOS 17');

insert into Product (code, name, price_eur, price_usd, description)
values
('HWIP60PW5774419', 'Huawei P60 Pro 8GB/256GB White', 1099.99, 1184.65, '6,67'''', LTPO OLED, 1B colors, 120Hz, Kunlun Glass, back camera: 48 MP Ultra Lighting Camera, Ultra-Wide Angle Camera, 48 MP Ultra Lighting Telephoto Camera, processor: Snapdragon 8+ Gen 1, 4815 mAh');

insert into Product (code, name, price_eur, price_usd, description)
values
('HWIN10SS4778201', 'Huawei Nova 10 8GB/128GB Starry Silver', 219.99, 236.92, '6.67'''' OLED 120Hz, Android 12, Snapdragon 778G 4G, 8GB RAM, 128GB ROM, Li-Po 4000 mAh');

--  REVIEWS
insert into Review (product_id, reviewer, text, rating)
values
(1, 'John Doe', 'Great product!', 5);

insert into Review (product_id, reviewer, text, rating)
values
(1, 'Haley Dunphy', 'Satisfied customer', 4);

insert into Review (product_id, reviewer, text, rating)
values
(1, 'Jane Smith', 'Could be better', 3);

insert into Review (product_id, reviewer, text, rating)
values
(1, 'Alice Bryant', 'Fast delivery', 4);

insert into Review (product_id, reviewer, text, rating)
values
(2, 'Bob Newbie', 'Average quality', 3);

insert into Review (product_id, reviewer, text, rating)
values
(2, 'Phil Dunphy', 'Love it!', 5);

insert into Review (product_id, reviewer, text, rating)
values
(2, 'Jay Pritchett', 'Good value for money', 4);

insert into Review (product_id, reviewer, text, rating)
values
(2, 'Cameron Tucker', 'Not what I expected', 2);

insert into Review (product_id, reviewer, text, rating)
values
(3, 'Manny Delgado', 'Excellent product!', 5);

insert into Review (product_id, reviewer, text, rating)
values
(3, 'Grace Taylor', 'Exactly as described', 4);

insert into Review (product_id, reviewer, text, rating)
values
(3, 'Frank Dunphy', 'Highly recommended', 5);

insert into Review (product_id, reviewer, text, rating)
values
(3, 'Harry Hole', 'Good service', 4);

insert into Review (product_id, reviewer, text, rating)
values
(4, 'Lily Evans', 'Nice product', 4);

insert into Review (product_id, reviewer, text, rating)
values
(4, 'Luke Dunphy', 'Best purchase ever!', 5);

insert into Review (product_id, reviewer, text, rating)
values
(4, 'James Potter', 'Awesome!', 5);

insert into Review (product_id, reviewer, text, rating)
values
(4, 'Walter White', 'Highly satisfied', 5);

insert into Review (product_id, reviewer, text, rating)
values
(5, 'J. Jonah Jameson', 'Crap!', 1);

insert into Review (product_id, reviewer, text, rating)
values
(5, 'Mitchell Pritchett', 'Poor packaging', 2);

insert into Review (product_id, reviewer, text, rating)
values
(5, 'Sherlock Holmes', 'Exactly what I needed', 4);

insert into Review (product_id, reviewer, text, rating)
values
(5, 'Peter Parker', 'Great value', 4);

insert into Review (product_id, reviewer, text, rating)
values
(6, 'Felicia Hardy', 'Happy with my purchase', 4);

insert into Review (product_id, reviewer, text, rating)
values
(6, 'John Watson', 'Good product', 4);

insert into Review (product_id, reviewer, text, rating)
values
(6, 'Gloria Pritchett', 'Impressed with the quality', 4);

insert into Review (product_id, reviewer, text, rating)
values
(6, 'Mary Jane Watson', 'Quality product', 4);

insert into Review (product_id, reviewer, text, rating)
values
(7, 'Nathan Never', 'Nice!', 4);

insert into Review (product_id, reviewer, text, rating)
values
(7, 'Irene Adler', 'Fast shipping', 4);

insert into Review (product_id, reviewer, text, rating)
values
(7, 'Lisbeth Salander', 'Decent', 3);

insert into Review (product_id, reviewer, text, rating)
values
(7, 'Alex Dunphy', 'Great deal', 4);

insert into Review (product_id, reviewer, text, rating)
values
(8, 'Mitchell McDeere', 'Highly recommend', 5);

insert into Review (product_id, reviewer, text, rating)
values
(8, 'Jesse Pinkman', 'Impressive', 5);

insert into Review (product_id, reviewer, text, rating)
values
(8, 'James Moriarty', 'Good experience', 4);

insert into Review (product_id, reviewer, text, rating)
values
(8, 'Hercule Poirot', 'Works perfectly', 5);