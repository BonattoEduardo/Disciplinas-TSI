# Acadêmico: Eduardo Richetti Bonatto
# RA: 2369990

conjunto <- c(
    10, 94, 32, 19, 55, 35, 20, 48, 68, 24, 18, 83, 30, 62, 85,
    50, 20, 90, 60, 14, 92, 20, 15, 58, 75, 16, 48, 81, 79, 46
)

## (1)

# Média
media <- mean(conjunto)
media # [1] 48.2333

# Mediana
mediana <- median(conjunto)
mediana # [1] 48

# Moda
tabela <- table(conjunto)
moda <- subset(tabela, tabela == max(tabela))
moda # 20 (3 vezes)

## (2)

# Variância
variancia <- var(conjunto)
variancia # [1] 766.047

# Desvio padrão
desvio_p <- sd(conjunto)
desvio_p # [1] 27.6776

# Coeficiente de variação
coeficiente_var <-  desvio_p / media * 100
coeficiente_var # [1] 57.3826

## (3)
quartis <- quantile(conjunto) # obtendo todos os quartis
quartis

q1 <- as.numeric(quartis[2]) # Q1
q1 # [1] 20
q2 <- as.numeric(quartis[3]) # Q2 (mediana)
q2 # [1] 48
q3 <- as.numeric(quartis[4]) # Q3
q3 # [1] 73.25

# Amplitude interquartílica
amplitude_iq <- q3 - q1
amplitude_iq # [1] 53.25

# Limite Inferior (LI)
limite_inf <- q1 - 1.5 * amplitude_iq
limite_inf # [1] -59.875

# Limite Superior (LS)
limite_sup <- q3 + 1.5 * amplitude_iq
limite_sup # [1] 153.125

## (4)
boxplot(conjunto)
# Interpretação: O gráfico é simétrico, ou seja, a distribuição dos dados tende
# a ser mais simétrica. Também é possível notar que existem mais elementos após
# o segundo quartil do que antes.

## (5)
library(moments)
assimetria <- skewness(conjunto)
assimetria # [1] 0.211297
# Interpretação: O coeficiente calculado indica que a distribuição é assimétrica
# positiva

## (6)

## Frequencia Absoluta
fas <- c()
elements <- unique(sort(conjunto))
for (i in  seq_along(elements)) {
    fas[i] <- length(conjunto[conjunto == elements[i]])
}

fas # [1] 1 1 1 1 1 1 3 1 1 1 1 1 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1

## Frequencia Absoluta Acumulada
faas <- c(fas[1])

for (i in 2:length(fas)) {
   faas[i] <- faas[i - 1] + fas[i]
}

faas
# [1]  1  2  3  4  5  6  9 10 11 12 13 14 16 17 18 19 20 21 22 23 24 25 26 27 28
# [26] 29 30

## Frequencia Relativa
options(digits = 3)

frs <- c()

for (i in seq_along(fas)) {
    frs[i] <- fas[i] / length(conjunto)
}

frs
# [1] 0.0333 0.0333 0.0333 0.0333 0.0333 0.0333 0.1000 0.0333 0.0333 0.0333
# [11] 0.0333 0.0333 0.0667 0.0333 0.0333 0.0333 0.0333 0.0333 0.0333 0.0333
# [21] 0.0333 0.0333 0.0333 0.0333 0.0333 0.0333 0.0333

## Frequencia Relativa Acumulada
fras <- c(frs[1])

for (i in 2:length(frs)) {
   fras[i] <- fras[i - 1] + frs[i]
}

fras
# [1] 0.0333 0.0667 0.1000 0.1333 0.1667 0.2000 0.3000 0.3333 0.3667 0.4000
# [11] 0.4333 0.4667 0.5333 0.5667 0.6000 0.6333 0.6667 0.7000 0.7333 0.7667
# [21] 0.8000 0.8333 0.8667 0.9000 0.9333 0.9667 1.0000

## Frequencia Percentual
fps <- c()

for (i in seq_along(fas)) {
    fps[i] <- fas[i] / length(conjunto) * 100
}

fps
# [1]  3.33  3.33  3.33  3.33  3.33  3.33 10.00  3.33  3.33  3.33  3.33  3.33
# [13]  6.67  3.33  3.33  3.33  3.33  3.33  3.33  3.33  3.33  3.33  3.33  3.33
# [25]  3.33  3.33  3.33

## Frequencia Percentual Acumulada
fpas <- c(fps[1])

for (i in 2:length(fps)) {
   fpas[i] <- fpas[i - 1] + fps[i]
}

fpas
# [1]   3.33   6.67  10.00  13.33  16.67  20.00  30.00  33.33  36.67  40.00
# [11]  43.33  46.67  53.33  56.67  60.00  63.33  66.67  70.00  73.33  76.67
# [21]  80.00  83.33  86.67  90.00  93.33  96.67 100.00

tabela <- data.frame(fas, faas, frs, fras, fps, fpas)
colnames(tabela) <- c("fa", "Fa", "fr", "Fr", "fp", "Fp")
tabela
#    fa Fa     fr     Fr    fp     Fp
# 1   1  1 0.0333 0.0333  3.33   3.33
# 2   1  2 0.0333 0.0667  3.33   6.67
# 3   1  3 0.0333 0.1000  3.33  10.00
# 4   1  4 0.0333 0.1333  3.33  13.33
# 5   1  5 0.0333 0.1667  3.33  16.67
# 6   1  6 0.0333 0.2000  3.33  20.00
# 7   3  9 0.1000 0.3000 10.00  30.00
# 8   1 10 0.0333 0.3333  3.33  33.33
# 9   1 11 0.0333 0.3667  3.33  36.67
# 10  1 12 0.0333 0.4000  3.33  40.00
# 11  1 13 0.0333 0.4333  3.33  43.33
# 12  1 14 0.0333 0.4667  3.33  46.67
# 13  2 16 0.0667 0.5333  6.67  53.33
# 14  1 17 0.0333 0.5667  3.33  56.67
# 15  1 18 0.0333 0.6000  3.33  60.00
# 16  1 19 0.0333 0.6333  3.33  63.33
# 17  1 20 0.0333 0.6667  3.33  66.67
# 18  1 21 0.0333 0.7000  3.33  70.00
# 19  1 22 0.0333 0.7333  3.33  73.33
# 20  1 23 0.0333 0.7667  3.33  76.67
# 21  1 24 0.0333 0.8000  3.33  80.00
# 22  1 25 0.0333 0.8333  3.33  83.33
# 23  1 26 0.0333 0.8667  3.33  86.67
# 24  1 27 0.0333 0.9000  3.33  90.00
# 25  1 28 0.0333 0.9333  3.33  93.33
# 26  1 29 0.0333 0.9667  3.33  96.67
# 27  1 30 0.0333 1.0000  3.33 100.00

## (7)

unicos <- unique(sort(conjunto))
freq <- cbind(unicos, fas)

suppressWarnings(suppressMessages(library("arm")))
discrete.histogram(conjunto, freq = TRUE, xlab = "", bar.width = 0.8)
lines(freq, type = "b", lwd = 3)

# Interpretação: a partir do gráfico, é possível perceber que a
# distribuição da maior parte dos elementos é homogênea, com apenas
# alguns elementos discrepantes