
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
