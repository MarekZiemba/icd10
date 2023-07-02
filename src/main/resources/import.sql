insert into specializations(id, name) values (1, 'psychiatra'), (2, 'psychoterapeuta'), (3, 'psychoterapeuta uzależnień'), (4, 'diagnosta');

insert into patients(insurance, dateOfBirth, firstName, lastName, pesel) values ('1234567891', '2000-01-01', 'Jan', 'Kowalski', '00010101150'), ('1234567892', '2002-01-01', 'Adam', 'Nowak', '02010101350'), ('1234567893', '1990-01-01', 'Jerzy', 'Wójcik', '90010101150');

insert into diagnoses(id, name, evaluationCriteria) values (1, 'Otępienia w chorobie Alzheimera', '• obecność:</br>— zaburzeń pamięci (”najwyraźniejsze w zakresie uczenia się nowych informacji”)</br>— zaburzeń innych funkcji poznawczych (osądu, myślenia, planowania, organizowania, ogólnego przetwarzania informacji), które pogorszyły się w stosunku do wcześniejszego, wyższego poziomu; w obu przypadkach w stopniu powodującym zaburzenia funkcjonowania w życiu codziennym; istnienie tych zaburzeń udokumentowano w rzetelnym wywiadzie od osób z najbliższego otoczenia chorego i, w miarę możliwości, w wynikach badania neuropsychologicznego lub „ilościowymi metodami oceny procesów poznawczych”</br>• zachowana „świadomość otoczenia”, tj. brak przymglenia świadomości (definiowanego jako „zmniejszona jasność” rozpoznawania otoczenia, z mniejszą zdolnością koncentracji, podtrzymywania i przemieszczania uwagi), przynajmniej przez czas niezbędny do stwierdzenia zaburzeń funkcji poznawczych; „w przypadku nawarstwienia się epizodów zaburzeń świadomości (delirium) rozpoznanie otępienia należy odroczyć”</br>• zmniejszenie emocjonalnej kontroli nad motywacją albo zmiana zachowań społecznych przejawiająca się co najmniej jednym z następujących objawów:</br>— chwiejność emocjonalna</br>— drażliwość</br>— apatia</br>— prymitywizacja zachowań społecznych</br>• występowanie zaburzeń pamięci oraz innych funkcji poznawczych od co najmniej 6 miesięcy</br>');

insert into specialists(id, specialization_id, dateOfBirth, firstName, lastName, pesel) values (1, 1, '1950-05-05', 'Jan', 'Frojd', '50050550550'), (2, 2, '1970-08-08', 'Anna', 'Terapia', '70080850881'), (3, 3, '1965-06-06', 'Zdzisław', 'Warga-Dziąślak', '65060650560'), (4, 4, '1990-05-05', 'Daniel', 'Nowy', '90050505550');

insert into treatments(id, name, description) values (1, 'porada psychologiczna', 'krótkoterminowa forma pomocy - może być źródłem informacji o nurtujących pacjenta tematach, a także pomóc osobom z konkretnym dylematem, może być wstępem do leczenia psychoterapeutycznego lub psychiatrycznego'), (2, 'psychoterapia indywidualna', 'zamierzone i systematyczne działanie przy użyciu wypróbowanych metod, którego skutkiem ma być poprawa funkcjonowania człowieka w jego otoczeniu i zredukowanie zaburzeń psychicznych. Psychoterapeuta razem z pacjentem pracuje nad usunięciem objawów chorobowych i rozwojem osobowości'), (3, 'terapia uzależnień', 'Podczas terapii osoba uzależniona zdobywa wiedzę na temat uzależnienia, jego objawów, przebiegu, konsekwencji oraz wpływu na wszystkie sfery życia. Terapia ma również na celu wzmocnienie motywacji do rezygnacji z czynnika uzależniającego i przejęcia odpowiedzialności za swoje życie i zdrowie'), (4, 'badanie lekarskie', 'Badanie przeprowadzane przez lekarza psychiatrę'), (5, 'badanie psychologiczne (diagnoza) - osobowości', 'Pomiar różnych cech osobowości. Pozwala sprawdzić, czy osoba doświadcza trudności psychicznych wpływających na jej życie'), (6, 'badanie psychologiczne (diagnoza) - inteligencji', 'Ocena poziomu inteligencji'), (7, 'badanie psychologiczne (diagnoza) - funkcji poznawczych', 'Polega na ocenie sprawności procesów poznawczych takich jak: pamięci, koncentracji uwagi, mowy, zdolności myślenia oraz procesów emocjonalno-osobowościowych');

insert into roles(id, name) values (1, 'admin'), (2, 'user');

insert into users (id, enabled, specialist_id, username, password) values (1, 1, 1, 'jan', '$2a$10$qWodKqdvvW0GWP.ajNceNuCl.yOdqUjPwBHKbyFDjLo99iX02Mc46'), (2, 1, 2, 'anna', '$2a$10$uoYr5Y1b8Sa234ShpZx49Onp9F5FZKbrzStlwDepctBQVdntqlc.u'), (3, 1, 3, 'zdzislaw', '$2a$10$uoYr5Y1b8Sa234ShpZx49Onp9F5FZKbrzStlwDepctBQVdntqlc.u'), (4, 1, 4, 'daniel', '$2a$10$uoYr5Y1b8Sa234ShpZx49Onp9F5FZKbrzStlwDepctBQVdntqlc.u');
# insert into users (id, enabled, role_id, specialist_id, username, password) values (1, 1, 1, 1, 'jan', '$2a$10$qWodKqdvvW0GWP.ajNceNuCl.yOdqUjPwBHKbyFDjLo99iX02Mc46'), (2, 1, 2, 2, 'anna', '$2a$10$uoYr5Y1b8Sa234ShpZx49Onp9F5FZKbrzStlwDepctBQVdntqlc.u'), (3, 1, 2, 3, 'zdzislaw', '$2a$10$uoYr5Y1b8Sa234ShpZx49Onp9F5FZKbrzStlwDepctBQVdntqlc.u'), (4, 1, 2, 4, 'daniel', '$2a$10$uoYr5Y1b8Sa234ShpZx49Onp9F5FZKbrzStlwDepctBQVdntqlc.u');

insert into visits(id, dateOfVisit, timeOfVisit, description, patient_id, treatment_id, specialist_id) values (1, '2023-06-01', '10:00:00', 'Od ostatniego spotkania, pacjent ... itd.itp.', 1, 4, 1);
insert into visits(id, dateOfVisit, timeOfVisit, description, patient_id, treatment_id, specialist_id) values (2, '2023-06-01', '11:00:00', 'Od ostatniej porady, pacjent ... itd.itp.', 2, 2, 2);

insert into patients_specialists(patients_id, specialists_id)values (1, 1);
insert into patients_specialists(patients_id, specialists_id)values (2, 2);
insert into patients_specialists(patients_id, specialists_id)values (3, 1);
insert into patients_specialists(patients_id, specialists_id)values (3, 2);

insert into patients_diagnoses(patients_id, diagnoses_id)values (1, 1);
insert into patients_diagnoses(patients_id, diagnoses_id)values (2, 1);
insert into patients_diagnoses(patients_id, diagnoses_id)values (3, 1);
# insert into patients_diagnoses(patients_id, diagnoses_id)values (3, 2);

insert into treatments_specialists(specialists_id, treatments_id)values (1, 4);
insert into treatments_specialists(specialists_id, treatments_id)values (2, 1);
insert into treatments_specialists(specialists_id, treatments_id)values (2, 2);
insert into treatments_specialists(specialists_id, treatments_id)values (3, 1);
insert into treatments_specialists(specialists_id, treatments_id)values (3, 3);
insert into treatments_specialists(specialists_id, treatments_id)values (4, 5);
insert into treatments_specialists(specialists_id, treatments_id)values (4, 6);
insert into treatments_specialists(specialists_id, treatments_id)values (4, 7);

insert into users_roles(roles_id, users_id) values (1, 1);
insert into users_roles(roles_id, users_id) values (2, 2);
insert into users_roles(roles_id, users_id) values (2, 3);
insert into users_roles(roles_id, users_id) values (2, 4);