
## Questão 1

# Horas de estudos semanais
h <- c(2, 7, 2, 1, 1, 1, 15)
# Notas semestrais
n <- c(18, 60, 20, 14, 15, 16, 82)

coeficiente <- sum((h - mean(h)) * (n - mean(n))) /
               (sqrt(sum((h - mean(h)) ^ 2)) * sqrt(sum((n - mean(n)) ^ 2)))

coeficiente
# [1] 0.9747042

library(ggplot2)
retas <- ggplot(mapping = aes(h, n)) +
         geom_point() +
         geom_smooth(se = FALSE, method = "lm")
retas

sxx <- sum(h * n) - (sum(n) * sum(h)) / length(h)
syy <- sum(h ^ 2) - (sum(h) ^ 2) / length(h)

beta_1 <- sxx / syy
beta_0 <- mean(n) - beta_1 * mean(h)

sqr <- sum((beta_0 + beta_1 * h - mean(n)) ^ 2)
sqt <- sum((n - mean(n)) ^ 2)
r2 <- sqr / sqt
r2
# [1] 0.9500482

## Questão 2

options(digits = 4)

## 90%
n <- 650
x <- 240
p <- x / n
alpha <- 0.1

z_alpha1 <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
ic <- c(
    p - z_alpha1 * sqrt(p * (1 - p) / n),
    p + z_alpha1 * sqrt(p * (1 - p) / n)
)
ic # [1] 0.3381 0.4004

## 95%
n <- 650
x <- 240
p <- x / n
alpha <- 0.05

z_alpha1 <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
ic <- c(
    p - z_alpha1 * sqrt(p * (1 - p) / n),
    p + z_alpha1 * sqrt(p * (1 - p) / n)
)
ic # [1] 0.3321 0.4063

## Questão 3

## 90%
options(digits = 8)

x_med <- 450
sigma <- 7
alpha <- 0.05
n <- 90

z_alpha5 <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
ic <- c(
    x_med - z_alpha5 * sigma / sqrt(n),
    x_med + z_alpha5 * sigma / sqrt(n)
)
ic # [1] 448.55381 451.44619

## 95%
options(digits = 8)

x_med <- 450
sigma <- 7
alpha <- 0.1
n <- 90

z_alpha5 <- qnorm(alpha / 2, mean = 0, sd = 1, lower.tail = FALSE)
ic <- c(
    x_med - z_alpha5 * sigma / sqrt(n),
    x_med + z_alpha5 * sigma / sqrt(n)
)
ic # [1] 448.78632 451.21368