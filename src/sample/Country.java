package sample;

/**
 * Obiekt klasy typu country tworzy oraz przechowuje domyślną listę miast, w których może
 * znajdować się szpital oraz domyślną listę granic i punktów granicznych
 */
public class Country
{
    /**
     * Tablica miast, w których można ulokować szpitale.
     */
    private City cities[] = new City [74];

    /**
     * Tablica punktów granicznych, które muszą być w zasięgu szpitali.
     */
    private City borders[] = new City [74];

    /**
     * Tablica punktów służących do wyznaczenia przybliżonych granic Państwa.
     */
    private City borderPoints[] = new City [9];

    /**
     * @return tablicę punktów granicznych, które muszą być w zasięgu szpitali
     */
    public City[] getBorders() { return borders; }

    /**
     * @return tablicę punktów służących do wyznaczenia przybliżonych granic Państwa.
     */
    public City[] getBorderPoints() { return borderPoints; }

    /**
     * @return tablicę miast, w których można ulokować szpitale.
     */
    public City[] getCities()
    {
        return cities;
    }

    /**
     * @param index przekazuje indeks szukanego miasta
     * @return zwraca miasto o zadanym indeksie
     */
    public City getCity (int index)
    {
        return cities[index];
    }

    /**
     * Konstruktor klasy Country wypełniający tablice cities[], borders[] oraz borderPoints[] domyślnymi wartościami
     */
    public Country()
    {
        cities[0] = new City(1, "Warszawa", 476, 295 );
        cities[1] = new City(2, "Kraków", 402, 540 );
        cities[2] = new City(3, "Łódź", 369, 343 );
        cities[3] = new City(4, "Wrocław", 201, 418 );
        cities[4] = new City(5, "Poznań", 193, 270 );
        cities[5] = new City(6, "Gdańsk", 311, 48 );
        cities[6] = new City(7, "Szczecin", 31, 155 );
        cities[7] = new City(8, "Bydgoszcz", 268, 190 );
        cities[8] = new City(9, "Lublin", 583, 405 );
        cities[9] = new City(10, "Białystok", 624, 189 );

        cities[10] = new City(11, "Katowice", 337, 517 );
        cities[11] = new City(12, "Gdynia", 304, 30 );
        cities[12] = new City(13, "Częstochowa", 345, 454 );
        cities[13] = new City(14, "Radom", 486, 386 );
        cities[14] = new City(15, "Sosnowiec", 346, 513 );
        cities[15] = new City(16, "Toruń", 310, 200 );
        cities[16] = new City(17, "Kielce", 448, 445 );
        cities[17] = new City(18, "Rzeszów", 545, 540 );
        cities[18] = new City(19, "Gliwice", 314, 514 );
        cities[19] = new City(20, "Zabrze", 321, 511 );

        cities[20] = new City(21, "Olsztyn", 440, 115 );
        cities[21] = new City(22, "Bielsko-Biała", 341, 565 );
        cities[22] = new City(23, "Bytom", 330, 502 );
        cities[23] = new City(24, "Zielona Góra", 95, 326 );
        cities[24] = new City(25, "Rybnik", 306, 536 );
        cities[25] = new City(26, "Ruda Śląska", 328, 515 );
        cities[26] = new City(27, "Opole", 263, 469 );
        cities[27] = new City(28, "Tychy", 335, 530 );
        cities[28] = new City(29, "Gorzów Wielkopolski", 77, 235 );
        cities[29] = new City(30, "Dąbrowa Górnicza", 356, 509 );

        cities[30] = new City(31, "Elbląg", 365, 71 );
        cities[31] = new City(32, "Płock", 385, 255 );
        cities[32] = new City(33, "Wałbrzych", 149, 456 );
        cities[33] = new City(34, "Włocławek", 340, 244 );
        cities[34] = new City(35, "Tarnów", 475, 542 );
        cities[35] = new City(36, "Chorzów", 333, 511 );
        cities[36] = new City(37, "Koszalin", 142, 70 );
        cities[37] = new City(38, "Kalisz", 279, 344 );
        cities[38] = new City(39, "Legnica", 142, 406 );
        cities[39] = new City(40, "Grudziądz", 321, 149 );

        cities[40] = new City(41, "Jaworzno", 355, 520 );
        cities[41] = new City(42, "Słupsk", 201, 37 );
        cities[42] = new City(43, "Jastrzębie-Zdrój", 308, 551 );
        cities[43] = new City(44, "Nowy Sącz", 454, 589 );
        cities[44] = new City(45, "Jelenia Góra", 111, 443 );
        cities[45] = new City(46, "Siedlce", 563, 297 );
        cities[46] = new City(47, "Mysłowice", 346, 519 );
        cities[47] = new City(48, "Konin", 286, 293 );
        cities[48] = new City(49, "Piotrków Trybunalski", 383, 386 );
        cities[49] = new City(50, "Piła", 182, 184 );

        cities[50] = new City(51, "Inowrocław", 285, 227 );
        cities[51] = new City(52, "Lubin", 144, 386 );
        cities[52] = new City(53, "Ostrów Wielkopolski", 256, 360 );
        cities[53] = new City(54, "Suwałki", 573, 79 );
        cities[54] = new City(55, "Ostrowiec Świętokrzyski", 501, 449 );
        cities[55] = new City(56, "Gniezno", 240, 257 );
        cities[56] = new City(57, "Stargard", 63, 166 );
        cities[57] = new City(58, "Głogów", 135, 357 );
        cities[58] = new City(59, "Siemianowice Śląskie", 339, 511 );
        cities[59] = new City(60, "Pabianice", 362, 355 );

        cities[60] = new City(51, "Zamość", 631, 463 );
        cities[61] = new City(52, "Leszno", 169, 335 );
        cities[62] = new City(53, "Łomża", 548, 183 );
        cities[63] = new City(54, "Chełm", 645, 417 );
        cities[64] = new City(55, "Tomaszów Mazowiecki", 408, 371 );
        cities[65] = new City(56, "Żory", 316, 540 );
        cities[66] = new City(57, "Ełk", 567, 149 );
        cities[67] = new City(58, "Stalowa Wola", 549, 485 );
        cities[68] = new City(59, "Pruszków", 461, 298 );
        cities[69] = new City(60, "Przemyśl", 597, 569 );

        cities[70] = new City(71, "Kędzierzyn-Koźle", 281, 505 );
        cities[71] = new City(72, "Tarnowskie Góry", 328, 494);
        cities[72] = new City(73, "Mielec", 504, 513 );
        cities[73] = new City(74, "Tczew", 317, 71 );


        borders[0] = new City(382, 40);
        borders[1] = new City(506, 56);
        borders[2] = new City(605, 47);
        borders[3] = new City(646, 75);
        borders[4] = new City(652, 125);
        borders[5] = new City(664, 167);
        borders[6] = new City(676, 189);
        borders[7] = new City(677, 238);
        borders[8] = new City(642, 257);
        borders[9] = new City(624, 288);

        borders[10] = new City(657, 312);
        borders[11] = new City(681, 333);
        borders[12] = new City(658, 385);
        borders[13] = new City(669, 417);
        borders[14] = new City(688, 447); // najdalej na E - 689 czy 688?
        borders[15] = new City(687, 471);
        borders[16] = new City(681, 499);
        borders[17] = new City(653, 515);
        borders[18] = new City(635, 533);
        borders[19] = new City(608, 569);

        borders[20] = new City(588, 596);
        borders[21] = new City(604, 648); // najdalej na S
        borders[22] = new City(560, 642);
        borders[23] = new City(548, 634);
        borders[24] = new City(529, 618);
        borders[25] = new City(505, 612);
        borders[26] = new City(489, 613);
        borders[27] = new City(471, 626);
        borders[28] = new City(457, 613);
        borders[29] = new City(428, 620);

        borders[30] = new City(411, 638);
        borders[31] = new City(390, 636);
        borders[32] = new City(387, 615);
        borders[33] = new City(370, 591);
        borders[34] = new City(336, 615);
        borders[35] = new City(327, 601);
        borders[36] = new City(312, 578);
        borders[37] = new City(291, 555);
        borders[38] = new City(261, 549);
        borders[39] = new City(242, 528);

        borders[40] = new City(225, 512);
        borders[41] = new City(190, 498);
        borders[42] = new City(200, 516);
        borders[43] = new City(179, 534);
        borders[44] = new City(148, 497);
        borders[45] = new City(160, 475);
        borders[46] = new City(132, 476);
        borders[47] = new City(99, 455);
        borders[48] = new City(80, 434);
        borders[49] = new City(56, 444);

        borders[50] = new City(65, 414);
        borders[51] = new City(61, 379);
        borders[52] = new City(46, 370);
        borders[53] = new City(38, 338);
        borders[54] = new City(44, 296);
        borders[55] = new City(32, 275);
        borders[56] = new City(33, 246);
        borders[57] = new City(1, 224); // najdalej na W
        borders[58] = new City(20, 195);
        borders[59] = new City(21, 164);

        borders[60] = new City(14, 127);
        borders[61] = new City(10, 104);
        borders[62] = new City(54, 89);
        borders[63] = new City(90, 75);
        borders[64] = new City(121, 66);
        borders[65] = new City(152, 53);
        borders[66] = new City(172, 31);
        borders[67] = new City(206, 16);
        borders[68] = new City(228, 8);
        borders[69] = new City(291, 1); // najdalej na N

        borders[70] = new City(297, 2);
        borders[71] = new City(324, 21);
        borders[72] = new City(307, 43);
        borders[73] = new City(342, 53);

        borderPoints[0] = new City(53, 96);
        borderPoints[1] = new City(53, 360);
        borderPoints[2] = new City(613, 96);
        borderPoints[3] = new City(613, 360);
        borderPoints[4] = new City(74, 360);
        borderPoints[5] = new City(74, 400);
        borderPoints[6] = new City(386, 556);
        borderPoints[7] = new City(201, 32);
        borderPoints[8] = new City(294, 77);
    }
}