insert into users(username, password) values ('mziemba', '$2a$10$t0aGfAueWe2cHnxe2pmZGey5Qd5xpv2NoE3vCusI.31dr3NBgfREa');
insert into insurance(insuranceNumber) values (1234567891), (1234567892), (1234567893);
insert into specializations(id, name) values (1, 'psychiatra'), (2, 'psychoterapeuta'), (3, 'psychoterapeuta uzależnień');

insert into patients(insurance_id, dateOfBirth, firstName, lastName, pesel) values (1, '2000-01-01', 'Jan', 'Kowalski', '00010101150'), (2, '2002-01-01', 'Adam', 'Nowak', '02010101350'), (3, '1990-01-01', 'Jerzy', 'Wójcik', '90010101150');

insert into categories(id, description, evaluationCriteria, name) values (1, 'choroba ciężka i przewlekła, mająca tendencje do nawrotów', 'obnizenie nastroju, brak energii, brak radośći, itp.', 'Depresja'), (2, 'pacjent w różnych okresach wpadas w manię lub przygnębienie, depresję', 'okresy manii, hipomanii i depresji', 'Choroba afektywna dwubiegunowa'), (3, 'głębokie zaburzenia, w których przebiegu występuje brak spójności między myśleniem, emocjami i zachowaniem', 'urojenia, omamy, zaburzenia mowy, dezorganizacja zachowania', 'Schozofrenia');

insert into specialists(id, specialization_id, dateOfBirth, firstName, lastName, pesel) values (1, 1, '1950-05-05', 'Jan', 'Frojd', '50050550550'), (2, 2, '1970-08-08', 'Anna', 'Terapia', '70080850881'), (3, 3, '1965-06-06', 'Zdzisław', 'Warga-Dziąślak', '65060650560');

insert into patients_specialists(patients_id, specialists_id)values (1, 1);
insert into patients_specialists(patients_id, specialists_id)values (2, 2);
insert into patients_specialists(patients_id, specialists_id)values (3, 1);
insert into patients_specialists(patients_id, specialists_id)values (3, 2);

insert into patients_categories(patients_id, categories_id)values (1, 1);
insert into patients_categories(patients_id, categories_id)values (2, 2);
insert into patients_categories(patients_id, categories_id)values (3, 1);
insert into patients_categories(patients_id, categories_id)values (3, 3);
