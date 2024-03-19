<h2> Домашние задания по курсу QA.GURU:</h2>

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/blob/main/src/test/java/tests/PracticeFormTests.java">Дз -
1.</a></li></h4>
– Разработайте один автотест на проверку формы https://demoqa.com/automation-practice-form.

Необходимо заполнить все поля формы (input, textarea, загрузка картинки и тд), а не только обязательные.

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/blob/main/src/test/java/anothertests/FindOnPageHomeWorkTest.java">
Дз - 2.</a></li></h4>
– Разработайте следующий автотест:
 <ol>
  <li>Откройте страницу Selenide в Github,</li> 
  <li>Перейдите в раздел Wiki проекта,</li>
  <li>Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions,</li>
  <li>Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5.</li></ol>

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/blob/main/src/test/java/anothertests/DragAndDropAndEnterpriseTest.java">
Дз - 3.</a></li></h4>
– На главной странице GitHub выберите меню Solutions -> Enterprise с помощью команды hover для Solutions. Убедитесь что
загрузилась нужная страница.
– Запрограммируйте Drag&Drop с помощью Selenide.actions():
 <ol>
  <li>Откройте https://the-internet.herokuapp.com/drag_and_drop,</li> 
  <li>Перенесите прямоугольник А на место В,</li>
  <li>Проверьте, что прямоугольники действительно поменялись,</li>
  <li>В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions().</li></ol>

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/tree/main/src/test/java/tests">
Дз - 4.</a></li></h4>
 <ol>
  <li>Взять код написанный в рамках ДЗ - 1 для формы https://demoqa.com/automation-practice-form,</li>
  <li>Добавить еще как минимум 2 автотеста - проверку минимального количества данных и негативную проверку,</li>
  <li>Добавить в код PageObjects / Components, в тестовом классе не должно остаться локаторов (таблицу с результатами введенных данных тоже вынести в components).</li></ol>

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/blob/main/src/test/java/tests/PracticeFormWithFakerTests.java">
Дз - 5.</a></li></h4>
<ol>
  <li>Взять код написанный в рамках ДЗ - 4 для формы https://demoqa.com/automation-practice-form (c PageObjects),</li>
  <li>Вынести все вводимые и проверяемые значения в переменные, добавить генерацию данных с Faker.</li></ol>

  <h4><li><a href="https://github.com/VeberAL/stepicTests">
Дз - 6.</a></li></h4>
<ol>
  <li>Написать свои варианты параметризованных wеб-тестов,</li>
  <li>Попробовать разные варианты датапровайдеров (аннотаций), минимум 3,</li>
  <li>Написать тест-кейс.</li></ol>

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/tree/main/src/test/java/tests/allure">
Дз - 7.</a></li></h4>

– Написать тест на проверку названия Issue в репозитории через Web-интерфейс.

Представить тест в трех вариантах:
<ol>
  <li>Чистый Selenide (с Listener),</li>
  <li>Лямбда шаги через step (name, () -> {}),</li>
  <li>Шаги с аннотацией @Step.</li></ol>

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/tree/main/src/test/java/tests/remotetest">
Дз - 8.</a></li></h4>

<ol>
  <li>Взять код для Дз - 6,</li>
  <li>Добавить аттачи для Allure – скриншот, page source, console.log и видео,</li>
  <li>Cделать сборку в <a href="https://jenkins.autotests.cloud/job/Group25_VeberAL/2/allure/">Jenkins</a>.</li></ol>

<h4><li><a href="https://github.com/VeberAL/QA.guruCourse/tree/main/src/test/java/tests/remotetest">
Дз - 9.</a></li></h4>

– Доработать код для Дз - 8:
<ol>
  <li>Передать из дженкинса адрес удаленного браузера (selenoid),</li>
  <li>Сделать возможность выбора браузера, версии и разрешения из сборки <a href="https://jenkins.autotests.cloud/job/Group25_VeberAL_1/">Jenkins</a>.</li></ol>