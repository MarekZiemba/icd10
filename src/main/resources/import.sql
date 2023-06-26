insert into specializations(id, name) values (1, 'psychiatra'), (2, 'psychoterapeuta'), (3, 'psychoterapeuta uzależnień'), (4, 'diagnosta');

insert into patients(insurance, dateOfBirth, firstName, lastName, pesel) values ('1234567891', '2000-01-01', 'Jan', 'Kowalski', '00010101150'), ('1234567892', '2002-01-01', 'Adam', 'Nowak', '02010101350'), ('1234567893', '1990-01-01', 'Jerzy', 'Wójcik', '90010101150');

insert into categories(id, description, evaluationCriteria, name) values (1, 'choroba ciężka i przewlekła, mająca tendencje do nawrotów', 'obnizenie nastroju, brak energii, brak radośći, itp.', 'Depresja'), (2, 'pacjent w różnych okresach wpadas w manię lub przygnębienie, depresję', 'okresy manii, hipomanii i depresji', 'Choroba afektywna dwubiegunowa'), (3, 'głębokie zaburzenia, w których przebiegu występuje brak spójności między myśleniem, emocjami i zachowaniem', 'urojenia, omamy, zaburzenia mowy, dezorganizacja zachowania', 'Schozofrenia');

insert into specialists(id, specialization_id, dateOfBirth, firstName, lastName, pesel) values (1, 1, '1950-05-05', 'Jan', 'Frojd', '50050550550'), (2, 2, '1970-08-08', 'Anna', 'Terapia', '70080850881'), (3, 3, '1965-06-06', 'Zdzisław', 'Warga-Dziąślak', '65060650560'), (4, 4, '1990-05-05', 'Daniel', 'Nowy', '90050505550');

insert into treatments(id, name, description) values (1, 'porada psychologiczna', 'krótkoterminowa forma pomocy - może być źródłem informacji o nurtujących pacjenta tematach, a także pomóc osobom z konkretnym dylematem, może być wstępem do leczenia psychoterapeutycznego lub psychiatrycznego'), (2, 'psychoterapia indywidualna', 'zamierzone i systematyczne działanie przy użyciu wypróbowanych metod, którego skutkiem ma być poprawa funkcjonowania człowieka w jego otoczeniu i zredukowanie zaburzeń psychicznych. Psychoterapeuta razem z pacjentem pracuje nad usunięciem objawów chorobowych i rozwojem osobowości'), (3, 'terapia uzależnień', 'Podczas terapii osoba uzależniona zdobywa wiedzę na temat uzależnienia, jego objawów, przebiegu, konsekwencji oraz wpływu na wszystkie sfery życia. Terapia ma również na celu wzmocnienie motywacji do rezygnacji z czynnika uzależniającego i przejęcia odpowiedzialności za swoje życie i zdrowie'), (4, 'badanie lekarskie', 'Badanie przeprowadzane przez lekarza psychiatrę'), (5, 'badanie psychologiczne (diagnoza) - osobowości', 'Pomiar różnych cech osobowości. Pozwala sprawdzić, czy osoba doświadcza trudności psychicznych wpływających na jej życie'), (6, 'badanie psychologiczne (diagnoza) - inteligencji', 'Ocena poziomu inteligencji'), (7, 'badanie psychologiczne (diagnoza) - funkcji poznawczych', 'Polega na ocenie sprawności procesów poznawczych takich jak: pamięci, koncentracji uwagi, mowy, zdolności myślenia oraz procesów emocjonalno-osobowościowych');

insert into patients_specialists(patients_id, specialists_id)values (1, 1);
insert into patients_specialists(patients_id, specialists_id)values (2, 2);
insert into patients_specialists(patients_id, specialists_id)values (3, 1);
insert into patients_specialists(patients_id, specialists_id)values (3, 2);

insert into patients_categories(patients_id, categories_id)values (1, 1);
insert into patients_categories(patients_id, categories_id)values (2, 2);
insert into patients_categories(patients_id, categories_id)values (3, 1);
insert into patients_categories(patients_id, categories_id)values (3, 3);

insert into treatments_specialists(specialists_id, treatments_id)values (1, 4);
insert into treatments_specialists(specialists_id, treatments_id)values (2, 1);
insert into treatments_specialists(specialists_id, treatments_id)values (2, 2);
insert into treatments_specialists(specialists_id, treatments_id)values (3, 1);
insert into treatments_specialists(specialists_id, treatments_id)values (3, 3);
insert into treatments_specialists(specialists_id, treatments_id)values (4, 5);
insert into treatments_specialists(specialists_id, treatments_id)values (4, 6);
insert into treatments_specialists(specialists_id, treatments_id)values (4, 7);
