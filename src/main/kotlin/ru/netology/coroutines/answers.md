# Cancellation

## Вопрос №1:

Нет, т.к. на родительской корутине "job" отмена происходит раньше, чем заканчивается период задержки
дочерней корутины в 500 мс.

## Вопрос №2:

Нет, т.к. отмена корутины "child" вызовом функции child.cancel() происходит раньше, чем
заканчивается период задержки корутины "child" в 500 мс. Вторая дочерняя корутина в "job"
отрабатывает до конца.

Не увидел того, чтобы "несмотря на отмену, дочерняя корутина доработала до конца", как говорилось в
лекции. Дополнил код для println'ами и поигрался с задержками. Дочерние корутины успевают
запускаться до отмены родительской, а println("ok") срабатывает только если отмена родительской или
соответствующей корутины наступила после его вызова.

# Exception Handling

## Вопрос №1:

Нет, т.к. try-catch, вызванный в родительской корутине, не обрабатывает исключения, выброшенные
запущенной в блоке дочерней корутиной.

## Вопрос №2:

Да, т.к. исключение выбрасывается и обрабатывается в рамках одной корутины.

## Вопрос №3:

Да, т.к. исключение выбрасывается и обрабатывается в рамках одной корутины.

## Вопрос №4:

Нет, т.к. исключение выбрасывается во второй дочерней корутине, а первая не успевает выполниться и
отменяется из-за исключения во второй.

## Вопрос №5:

В первой дочерней корутине строка отработает, т.к. обе дочерние корутины лежат в supervisorScope, а
значит не влияют друг на друга.
Блок catch не отработает, т.к. функция supervisorScope, в отличие от coroutineScope, не предоставляет 
перехваченные во вложенных корутинах исключения.

## Вопрос №6:

Нет, т.к. сначала сработает исключение, после чего данная корутина и её дочерние корутины будут отменены.

## Вопрос №7:

Нет, т.к. сначала сработает исключение, после чего данная корутина и её дочерние корутины будут отменены.
