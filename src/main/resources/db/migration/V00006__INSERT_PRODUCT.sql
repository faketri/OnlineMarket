-- Вставка данных в таблицу product
INSERT INTO product (
    id, description, discount, is_promo_item, name_model, price, promo_price, quantity, quantity_sold, brand_id, categories_id
) VALUES(
         '850e8400-e29b-41d4-a716-446655440000',
         'Высокопроизводительный ноутбук с 16 ГБ оперативной памяти и 512 ГБ SSD.',
         10,
         TRUE,
         'Vaio',
         100000,
         90000,
         50,
         20,
         '650e8400-e29b-41d4-a716-446655440000',
         '750e8400-e29b-41d4-a716-446655440000'
 ),(
        '850e8400-e29b-41d4-a716-446655440001',
        'Новый смартфон с передовыми функциями и отличной камерой.',
        15,
        TRUE,
        'Galaxy S21',
        80000,
        68000,
        100,
        50,
        '650e8400-e29b-41d4-a716-446655440001',
        '750e8400-e29b-41d4-a716-446655440001'
),(
        '850e8400-e29b-41d4-a716-446655440002',
        'Смартфон Apple iPhone 12 с встроенной памятью 128 ГБ и экраном 6.1 дюйма представляет собой устройство, которое сочетает технологические достижения Apple и привлекательный дизайн корпуса из стекла и металла. Дисплей выполнен на основе матрицы Retina XDR с защитным покрытием Ceramic Shield. Двойная система камер (12 Мп основная и 12 Мп сверхширокоугольная) предоставляют возможность записи видео в формате 4K HDR с Dolby Vision. Поддержка 5G обеспечивает высокие скорости загрузки и трансляции потокового видео с использованием Apple iPhone 12. Face ID отвечает за безопасное разблокирование устройства с помощью системы распознавания лица. Технология MagSafe служит для магнитного крепления аксессуаров и беспроводной зарядки.',
        5,
        FALSE,
        'iPhone 12',
        120000,
        114000,
        75,
        30,
        '650e8400-e29b-41d4-a716-446655440002',
        '750e8400-e29b-41d4-a716-446655440001'
),(
        '850e8400-e29b-41d4-a716-446655440003',
        'Bluetooth гарнитура Sony WH-1000XM4 выполнена в классическом стиле, за которым скрываются широкие функциональные возможности и технологичность премиального уровня. К преимуществам данной модели относятся 40-мм динамики с расширенным частотным диапазоном и технология активного шумоподавления ANC. Интегрированный микрофон способен с высокой четкостью передавать речь. Гарнитура Sony WH-1000XM4 подключается к устройствам по беспроводной технологии Bluetooth или проводным способом по аудиокабелю. Мягкие охватывающие амбушюры, регулируемое оголовье и складная конструкция способствуют исключительному комфорту в эксплуатации гарнитуры. В режиме воспроизведения музыки гарнитура способна работать автономно до 30 часов. Среди прочих особенностей отмечаются функция быстрой зарядки, поддержка NFC и голосовое управление.',
        20,
        FALSE,
        'WH-1000XM4',
        35000,
        28000,
        40,
        15,
        '650e8400-e29b-41d4-a716-446655440000',
        '750e8400-e29b-41d4-a716-446655440002'
),(
        '850e8400-e29b-41d4-a716-446655440004',
        'Смарт-часы Apple Watch Series 6 GPS позволяют вам измерять уровень кислорода в крови с помощью передового датчика и специального приложения. Просматривайте показатели физической активности на улучшенном, всегда включенном дисплее Retina, который теперь светится в 2.5 раза ярче на улице, в неактивном режиме, когда рука с часами внизу. Настройте набор действий, необходимых вам перед сном, и отслеживайте свой режим сна. Отвечайте на звонки и сообщения прямо с запястья. Apple Watch Series 6 GPS - это мощное устройство, с которым гораздо проще вести более здоровый образ жизни, быть активнее и оставаться на связи.',
        10,
        FALSE,
        'Watch Series 6',
        40000,
        36000,
        60,
        25,
        '650e8400-e29b-41d4-a716-446655440002',
        '750e8400-e29b-41d4-a716-446655440010'
),(
        '850e8400-e29b-41d4-a716-446655440005',
        'Этот ноутбук создан для тех, кто хочет получить хорошее производительное компьютерное устройство с наиболее востребованным функционалом. Данная модель полностью удовлетворяет данные требования. Надежный накопитель предоставляет вам возможности для долговременного хранения необходимой виртуальной информации. Устройство оборудовано веб-камерой и микрофоном, благодаря которым вы сможете организовывать видеоконференции с партнерами по бизнесу и коллегами по работе.',
        8,
        FALSE,
        'XPS 13',
        120000,
        110000,
        35,
        10,
        '650e8400-e29b-41d4-a716-446655440003',
        '750e8400-e29b-41d4-a716-446655440000'
),(
        '850e8400-e29b-41d4-a716-446655440006',
        'Наушники TWS Samsung Buds Pro — высококачественная стереогарнитура для общения и прослушивания любимых композиций. Благодаря отсутствию проводов, модель оптимальна для использовать во время тренировок или прогулок. Компактный и легкий корпус из износостойкого пластика имеет высокую степень защиты от воды IPX7. Наушники TWS Samsung Buds Pro с двухполосными динамиками обеспечивает чистое, глубокое и насыщенное звучание. Система из трех микрофонов обеспечивает максимально качественную передачу речи во время телефонных звонков даже при наличии посторонних шумов. В режиме звучания модель работает до 5 ч. Для быстрого заряда есть удобный флип-кейс, который используется также для хранения и транспортировки.',
        12,
        FALSE,
        'Galaxy Buds Pro',
        20000,
        17500,
        80,
        40,
        '650e8400-e29b-41d4-a716-446655440001',
        '750e8400-e29b-41d4-a716-446655440002'
),

(
        '850e8400-e29b-41d4-a716-446655440007',
        'Компактный и мощный смартфон с отличным временем автономной работы.',
        7,
        FALSE,
        'iPhone SE',
        50000,
        46500,
        70,
        20,
        '650e8400-e29b-41d4-a716-446655440002',
        '750e8400-e29b-41d4-a716-446655440001'
),(
        '850e8400-e29b-41d4-a716-446655440008',
        'Универсальный ноутбук для работы и развлечений.',
        9,
        FALSE,
        'Vaio Z',
        150000,
        135000,
        25,
        5,
        '650e8400-e29b-41d4-a716-446655440000',
        '750e8400-e29b-41d4-a716-446655440000'
),(
        '850e8400-e29b-41d4-a716-446655440009',
        'Смартфон Samsung Galaxy Note 20 зеленого цвета обеспечивает быструю загрузку и работу приложений, подходит для выполнения серьезных задач, игр и общения. Корпус изготовлен из высокопрочного металла, а уровень защиты IP68 защищает от воздействия влаги и пыли. Внутренняя память рассчитана на хранение до 256 ГБ информации, что избавит от необходимости удалять фото и видео. Смартфон Samsung Galaxy Note 20 с дисплеем Super AMOLED Plus размером 6.7 дюймов позволяет насладиться многообразием цветов и оттенков. Модель имеет большое количество датчиков, в том числе освещенности, приближения, магнитными и другими, которые облегчают эксплуатацию. Для управления сенсорным экраном можно использовать стилус, для которого в корпусе предусмотрен специальный разъем. Камера состоит из трех сенсоров, которые передают мельчайшие детали и естественные цвета. Энергоемкая батарея позволяет использовать устройство более суток без подзарядки.',
        6,
        FALSE,
        'Samsung Galaxy Note 20',
        95000,
        89500,
        45,
        15,
        '650e8400-e29b-41d4-a716-446655440001',
        '750e8400-e29b-41d4-a716-446655440001'
),(
        '850e8400-e29b-41d4-a716-446655440010',
        'Ноутбук MSI Katana B12VFK-463XRU создан для погружения в захватывающий виртуальный мир. Он отличается мощными комплектующими, стабильностью при разных вычислительных нагрузках и технологичностью. Аппаратная конфигурация состоит из дискретной видеокарты GeForce RTX 4060 от NVIDIA, процессора Intel Core i5, 16 ГБ памяти ОЗУ и твердотельного накопителя SSD 512 ГБ. Эти компоненты гарантируют высокую производительность в играх и требовательных программах. Система охлаждения Cooler Boost 5 с тепловыми трубками и вентиляторами поддерживает низкий нагрев платформы. В MSI Katana B12VFK-463XRU установлен экран 17.3 дюйма IPS с матовой поверхностью и частотой 144 Гц, на котором отображается реалистичная картинка. Акустическая система Nahimic воспроизводит чистый и насыщенный звук. Для комфортного управления в любое время суток реализована полноразмерная клавиатура с подсветкой RGB. Аккумулятор гарантирует около 6 часов автономности геймерского ноутбука.',
        9,
        FALSE,
        'Katana B12VFK-463XRU',
        99899,
        85699,
        25,
        5,
        '650e8400-e29b-41d4-a716-446655440009',
        '750e8400-e29b-41d4-a716-446655440000'
)
,(
        '850e8400-e29b-41d4-a716-446655440011',
        'Видеокарта GIGABYTE GeForce RTX 2060 D6 6G с архитектурой NVIDIA Turing способна обеспечить высокий уровень вычислительной мощности в ресурсоемких приложениях и компьютерных играх. Процессор функционирует с частотой на уровне 1365 МГц в штатном режиме и частотой в режиме разгона на уровне показателя 1680 МГц. В конфигурацию графического ускорителя также входят 6 ГБ видеопамяти. Для подключения к источникам изображения в GIGABYTE GeForce GTX 2060 предлагаются 3 разъема DisplayPort и 1 HDMI. Система охлаждения с радиатором и двумя вентиляторами быстро отводит тепло и предотвращает перегрев даже при продолжительных нагрузках. Металлическая пластина жесткости на обратной стороне повышает стойкость к механическим воздействиям и деформации.',
        9,
        FALSE,
        'RTX 2060 D6 6G (rev. 2.0) [GV-N2060D6-6GD rev2.0]',
        35000,
        0,
        25,
        5,
        '650e8400-e29b-41d4-a716-446655440008',
        '750e8400-e29b-41d4-a716-446655440004'
),(
        '850e8400-e29b-41d4-a716-446655440012',
        'Серия Ventus ориентирована на скорость, поэтому в конструкции этих видеокарт нет ничего лишнего. За их охлаждение отвечает кулер с тремя вентиляторами, а строгий дизайн гармонично впишется в любую компьютерную сборку.',
        9,
        FALSE,
        'GeForce RTX 3060 Ti VENTUS 3X OC [RTX 3060 Ti VENTUS 3X 8GD6X OC]',
        35000,
        0,
        25,
        5,
        '650e8400-e29b-41d4-a716-446655440009',
        '750e8400-e29b-41d4-a716-446655440004'
);


-- MSI Katana B12VFK-463XRU (Высокопроизводительный ноутбук)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655450101'), -- Диагональ экрана 17 дюймов
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440103'), -- Объем памяти 512 ГБ
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655441105'), -- SSD
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440106'), -- Linux
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440001'), -- Intel Core i7
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440171'), -- Количество ядер 12
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440102'), -- Разрешение экрана 3200x1440
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440112'), -- NVIDIA GeForce RTX 3090
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440673'), -- Частота обновления экрана 144 ГЦ
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440005'), -- 5000 МаЧ
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440002'), -- Оперативная память 16 ГБ
('850e8400-e29b-41d4-a716-446655440010', '950e8400-e29b-41d4-a716-446655440020'); -- Материал Алюминий

-- Sony Vaio (Высокопроизводительный ноутбук)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440000'), -- Диагональ экрана 15.6 дюймов
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440180'), -- Объем памяти 256 ГБ
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440104'), -- SSD
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440017'), -- Windows 11
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440001'), -- Intel Core i7
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440171'), -- Количество ядер 12
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440052'), -- Разрешение экрана 2560x1600
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440011'), -- NVIDIA GeForce RTX 3080
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440005'), -- 5000 МаЧ
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440673'), -- Частота обновления экрана 144 ГЦ
('850e8400-e29b-41d4-a716-446655440000', '950e8400-e29b-41d4-a716-446655440020'); -- Материал Алюминий

-- Sony Vaio Z (Высокопроизводительный ноутбук)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655450101'), -- Диагональ экрана 17 дюймов
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440124'), -- Объем памяти 256 ГБ
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440104'), -- SSD
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440017'), -- Windows 11
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440001'), -- Intel Core i7
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440171'), -- Количество ядер 12
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440052'), -- Разрешение экрана 2560x1600
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440115'), -- AMD Radeon RX 6400
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440046'), -- 6000 МаЧ
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440673'), -- Частота обновления экрана 144 ГЦ
('850e8400-e29b-41d4-a716-446655440008', '950e8400-e29b-41d4-a716-446655440020'); -- Материал Алюминий

-- Samsung Galaxy S21 (Новый смартфон с передовыми функциями и отличной камерой)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440075'), -- Android 11
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440004'), -- Разрешение камеры 12 Мп
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440014'), -- Поддержка 5G сети
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440019'), -- Разъемы USB-C
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440068'), -- Быстрая зарядка
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440080'), -- Беспроводная зарядка Да
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440101'), -- Процессор Exynos 2100
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440170'), -- Количество ядер 8
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440032'), -- Водонепроницаемость IP67
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440086'), -- Объем памяти 128 ГБ
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440069'), -- 4000 МаЧ
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440473'), -- Частота обновления экрана 90 ГЦ
('850e8400-e29b-41d4-a716-446655440001', '950e8400-e29b-41d4-a716-446655440130'); -- Материал Пластик

-- iPhone 12 (Популярный смартфон с элегантным дизайном и мощной производительностью)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440079'), -- iOS
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440004'), -- Разрешение камеры 12 Мп
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440014'), -- Поддержка 5G сети
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440019'), -- Разъемы USB-C
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440068'), -- Быстрая зарядка
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440080'), -- Беспроводная зарядка Да
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440274'), -- Процессор Apple A14 Bionic
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440086'), -- Объем памяти 128 ГБ
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440189'), -- Оперативная память 4 ГБ
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440073'), -- Частота обновления экрана 60 ГЦ
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440469'), -- 3750 МаЧ
('850e8400-e29b-41d4-a716-446655440002', '950e8400-e29b-41d4-a716-446655440020'); -- Материал Алюминий

-- iPhone SE (Популярный смартфон с элегантным дизайном и мощной производительностью)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440079'), -- iOS
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440004'), -- Разрешение камеры 12 Мп
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655441114'), -- Поддержка 5G сети
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440019'), -- Разъемы USB-C
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440068'), -- Быстрая зарядка
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440580'), -- Беспроводная зарядка Нет
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440274'), -- Процессор Apple A14 Bionic
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440180'), -- Объем памяти 256 ГБ
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440189'), -- Оперативная память 4 ГБ
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440073'), -- Частота обновления экрана 60 ГЦ
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440469'), -- 3750 МаЧ
('850e8400-e29b-41d4-a716-446655440007', '950e8400-e29b-41d4-a716-446655440020'); -- Материал Алюминий

-- Sony WH-1000XM4 (Беспроводные наушники с шумоподавлением)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440003', '950e8400-e29b-41d4-a716-446655440033'), -- Диаметр динамиков 40 мм
('850e8400-e29b-41d4-a716-446655440003', '950e8400-e29b-41d4-a716-446655440034'), -- Частотный диапазон 20-20000 Гц
('850e8400-e29b-41d4-a716-446655440003', '950e8400-e29b-41d4-a716-446655440016'), -- Технология звука Dolby Atmos
('850e8400-e29b-41d4-a716-446655440003', '950e8400-e29b-41d4-a716-446655440059'), -- Bluetooth 5
('850e8400-e29b-41d4-a716-446655440003', '950e8400-e29b-41d4-a716-446655440130'); -- Материал Пластик

-- Apple Watch Series 6 (Умные часы с фитнес-трекером и уведомлениями)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440004', '950e8400-e29b-41d4-a716-446655440038'), -- Технология дисплея Retina
('850e8400-e29b-41d4-a716-446655440004', '950e8400-e29b-41d4-a716-446655440018'), -- Биометрическая защита Сканер отпечатка пальца
('850e8400-e29b-41d4-a716-446655440004', '950e8400-e29b-41d4-a716-446655440067'), -- Голосовой помощник Siri
('850e8400-e29b-41d4-a716-446655440004', '950e8400-e29b-41d4-a716-446655440059'), -- Bluetooth 5
('850e8400-e29b-41d4-a716-446655440004', '950e8400-e29b-41d4-a716-446655440006'), -- Технология экрана OLED
('850e8400-e29b-41d4-a716-446655440004', '950e8400-e29b-41d4-a716-446655440379'), -- Система Watch OS
('850e8400-e29b-41d4-a716-446655440004', '950e8400-e29b-41d4-a716-446655440020'); -- Материал Алюминий


-- Dell XPS 13 (Ультралегкий и мощный ноутбук для повседневного использования)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440100'), -- Диагональ экрана 14 дюймов
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440180'), -- Объем памяти 256 ГБ
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440104'), -- SSD
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440106'), -- Linux
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440001'), -- Intel Core i7
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440052'), -- Разрешение экрана 2560x1600
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440113'), -- NVIDIA GeForce RTX 1650
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440005'), -- 5000 МаЧ
('850e8400-e29b-41d4-a716-446655440005', '950e8400-e29b-41d4-a716-446655440020'); -- Материал Алюминий

-- Samsung Galaxy Buds Pro (Высококачественные беспроводные наушники с отличным звуком)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440006', '950e8400-e29b-41d4-a716-446655440033'), -- Диаметр динамиков 40 мм
('850e8400-e29b-41d4-a716-446655440006', '950e8400-e29b-41d4-a716-446655440034'), -- Частотный диапазон 20-20000 Гц
('850e8400-e29b-41d4-a716-446655440006', '950e8400-e29b-41d4-a716-446655440016'), -- Технология звука Dolby Atmos
('850e8400-e29b-41d4-a716-446655440006', '950e8400-e29b-41d4-a716-446655440059'), -- Bluetooth 5
('850e8400-e29b-41d4-a716-446655440006', '950e8400-e29b-41d4-a716-446655440130'); -- Материал Пластик

-- Samsung Samsung Galaxy Note 20 (Новый смартфон с передовыми функциями и отличной камерой)
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440075'), -- Android 11
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440047'), -- Разрешение камеры 12 Мп
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440014'), -- Поддержка 5G сети
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440019'), -- Разъемы USB-C
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440068'), -- Быстрая зарядка
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440080'), -- Беспроводная зарядка Да
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440101'), -- Процессор Exynos 2100
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440170'), -- Количество ядер 8
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440032'), -- Водонепроницаемость IP67
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440086'), -- Объем памяти 128 ГБ
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440469'), -- 4000 МаЧ
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440473'), -- Частота обновления экрана 90 ГЦ
('850e8400-e29b-41d4-a716-446655440009', '950e8400-e29b-41d4-a716-446655440130'); -- Материал Пластик

-- MSI GeForce RTX 3060 Ti VENTUS 3X OC [RTX 3060 Ti VENTUS 3X 8GD6X OC]
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440012', '950e8400-e29b-41d4-a716-446655440335'),
('850e8400-e29b-41d4-a716-446655440012', '950e8400-e29b-41d4-a716-446655440336'),
('850e8400-e29b-41d4-a716-446655440012', '950e8400-e29b-41d4-a716-446655440337'),
('850e8400-e29b-41d4-a716-446655440012', '950e8400-e29b-41d4-a716-446655440338');

-- Gigabyte 2060
INSERT INTO product_characteristics (products_id, characteristics_id) VALUES
('850e8400-e29b-41d4-a716-446655440011', '950e8400-e29b-41d4-a716-446655440331'),
('850e8400-e29b-41d4-a716-446655440011', '950e8400-e29b-41d4-a716-446655440332'),
('850e8400-e29b-41d4-a716-446655440011', '950e8400-e29b-41d4-a716-446655440333'),
('850e8400-e29b-41d4-a716-446655440011', '950e8400-e29b-41d4-a716-446655440334');


------------------------------------------------------------------------------------------------------------------------------------
-- Iphone 12
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440110', '850e8400-e29b-41d4-a716-446655440002'),
('550e8400-e29b-41d4-a716-446655440011', '850e8400-e29b-41d4-a716-446655440002'),
('550e8400-e29b-41d4-a716-446655440012', '850e8400-e29b-41d4-a716-446655440002'),
('550e8400-e29b-41d4-a716-446655440013', '850e8400-e29b-41d4-a716-446655440002'),
('550e8400-e29b-41d4-a716-446655440014', '850e8400-e29b-41d4-a716-446655440002');

-- Msi Katana
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440054', '850e8400-e29b-41d4-a716-446655440010'),
('550e8400-e29b-41d4-a716-446655440055', '850e8400-e29b-41d4-a716-446655440010'),
('550e8400-e29b-41d4-a716-446655440056', '850e8400-e29b-41d4-a716-446655440010'),
('550e8400-e29b-41d4-a716-446655440057', '850e8400-e29b-41d4-a716-446655440010'),
('550e8400-e29b-41d4-a716-446655440058', '850e8400-e29b-41d4-a716-446655440010'),
('550e8400-e29b-41d4-a716-446655440059', '850e8400-e29b-41d4-a716-446655440010'),
('550e8400-e29b-41d4-a716-446655440060', '850e8400-e29b-41d4-a716-446655440010'),
('550e8400-e29b-41d4-a716-446655440061', '850e8400-e29b-41d4-a716-446655440010');

-- Sony Viao
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440039', '850e8400-e29b-41d4-a716-446655440000'),
('550e8400-e29b-41d4-a716-446655440040', '850e8400-e29b-41d4-a716-446655440000'),
('550e8400-e29b-41d4-a716-446655440041', '850e8400-e29b-41d4-a716-446655440000'),
('550e8400-e29b-41d4-a716-446655440042', '850e8400-e29b-41d4-a716-446655440000'),
('550e8400-e29b-41d4-a716-446655440043', '850e8400-e29b-41d4-a716-446655440000'),
('550e8400-e29b-41d4-a716-446655440044', '850e8400-e29b-41d4-a716-446655440000');

-- Apple Watch 6
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440015', '850e8400-e29b-41d4-a716-446655440004'),
('550e8400-e29b-41d4-a716-446655440016', '850e8400-e29b-41d4-a716-446655440004'),
('550e8400-e29b-41d4-a716-446655440017', '850e8400-e29b-41d4-a716-446655440004'),
('550e8400-e29b-41d4-a716-446655440018', '850e8400-e29b-41d4-a716-446655440004'),
('550e8400-e29b-41d4-a716-446655440019', '850e8400-e29b-41d4-a716-446655440004');

-- Dell XPS 13
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440020', '850e8400-e29b-41d4-a716-446655440005'),
('550e8400-e29b-41d4-a716-446655440021', '850e8400-e29b-41d4-a716-446655440005'),
('550e8400-e29b-41d4-a716-446655440022', '850e8400-e29b-41d4-a716-446655440005'),
('550e8400-e29b-41d4-a716-446655440023', '850e8400-e29b-41d4-a716-446655440005'),
('550e8400-e29b-41d4-a716-446655440024', '850e8400-e29b-41d4-a716-446655440005');

-- Samsung Galaxy Buds Pro
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440025', '850e8400-e29b-41d4-a716-446655440006'),
('550e8400-e29b-41d4-a716-446655440026', '850e8400-e29b-41d4-a716-446655440006'),
('550e8400-e29b-41d4-a716-446655440027', '850e8400-e29b-41d4-a716-446655440006'),
('550e8400-e29b-41d4-a716-446655440028', '850e8400-e29b-41d4-a716-446655440006'),
('550e8400-e29b-41d4-a716-446655440029', '850e8400-e29b-41d4-a716-446655440006'),
('550e8400-e29b-41d4-a716-446655440030', '850e8400-e29b-41d4-a716-446655440006'),
('550e8400-e29b-41d4-a716-446655440031', '850e8400-e29b-41d4-a716-446655440006');

-- Samsung Galaxy s21
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440032', '850e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440033', '850e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440034', '850e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440035', '850e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440036', '850e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440037', '850e8400-e29b-41d4-a716-446655440001');

-- Sony WH 1000XHM4
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440045', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440046', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440047', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440048', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440049', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440050', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440051', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440052', '850e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440053', '850e8400-e29b-41d4-a716-446655440003');

-- Iphone SE
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440062', '850e8400-e29b-41d4-a716-446655440007'),
('550e8400-e29b-41d4-a716-446655440063', '850e8400-e29b-41d4-a716-446655440007'),
('550e8400-e29b-41d4-a716-446655440064', '850e8400-e29b-41d4-a716-446655440007'),
('550e8400-e29b-41d4-a716-446655440065', '850e8400-e29b-41d4-a716-446655440007'),
('550e8400-e29b-41d4-a716-446655440066', '850e8400-e29b-41d4-a716-446655440007');

-- Sonu vaio Z
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440067', '850e8400-e29b-41d4-a716-446655440008'),
('550e8400-e29b-41d4-a716-446655440068', '850e8400-e29b-41d4-a716-446655440008'),
('550e8400-e29b-41d4-a716-446655440069', '850e8400-e29b-41d4-a716-446655440008');

-- Samsung-Galaxy-Note-20
insert into product_image(image_id, product_id) values
('550e8400-e29b-41d4-a716-446655440072', '850e8400-e29b-41d4-a716-446655440009'),
('550e8400-e29b-41d4-a716-446655440073', '850e8400-e29b-41d4-a716-446655440009');

-- MSI GeForce RTX 3060 Ti VENTUS 3X OC [RTX 3060 Ti VENTUS 3X 8GD6X OC]
INSERT INTO product_image (product_id, image_id) VALUES
('850e8400-e29b-41d4-a716-446655440012', '550e8400-e29b-41d4-a716-446655440074'),
('850e8400-e29b-41d4-a716-446655440012', '550e8400-e29b-41d4-a716-446655440075'),
('850e8400-e29b-41d4-a716-446655440012', '550e8400-e29b-41d4-a716-446655440076');

-- Gigabyte 2060
INSERT INTO product_image (product_id, image_id) VALUES
('850e8400-e29b-41d4-a716-446655440011', '550e8400-e29b-41d4-a716-446655440077'),
('850e8400-e29b-41d4-a716-446655440011', '550e8400-e29b-41d4-a716-446655440078'),
('850e8400-e29b-41d4-a716-446655440011', '550e8400-e29b-41d4-a716-446655440079');
