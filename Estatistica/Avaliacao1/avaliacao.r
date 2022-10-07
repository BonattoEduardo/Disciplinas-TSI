# Acadêmico: Eduardo Richetti Bonatto
# RA: 2369990

conjunto <- c(
    8.5, 6.8, 8.1, -0.2, 3.9, 4.7, 5.1, -2.3, 4.9, 4.8, 4.4, 6.2, 9.8, 3.9, 8.2,
    11.8, 10.3, 4.9, 7.2, 9.5, 10.5, -1.7, 13.8, 1.9, 5.6, 17.3, 0.0, 4.2, 5.4,
    6.3, 3.7, 6.4, 2.8, 2.1, 3.6, 10.6, 2.3, 11.6, 9.1, 3.3, 4.2, 12.5, 2.1,
    3.0, 9.4
)

### Exercício 1

## (A)

# Média
media <- mean(conjunto)
media # [1] 6.011111

# Mediana
mediana <- median(conjunto)
mediana # [1] 5.1

# Moda
tabela <- table(conjunto)
moda <- subset(tabela, tabela == max(tabela))
moda # 2.1 3.9 4.2 4.9

## (B)

# Variância
variancia <- var(conjunto)
variancia # [1] 16.98328

# Desvio padrão
desvio_p <- sd(conjunto)
desvio_p # [1] 4.121078

# Coeficiente de variação
coeficiente_var <-  desvio_p / media * 100
coeficiente_var # [1] 68.55767

## (C)
quartis <- quantile(conjunto) # obtendo todos os quartis
quartis

q1 <- as.numeric(quartis[2]) # Q1
q1 # [1] 3.6
q2 <- as.numeric(quartis[3]) # Q2 (mediana)
q2 # [1] 5.1
q3 <- as.numeric(quartis[4]) # Q3
q3 # [1] 9.1

# Amplitude interquartílica
amplitude_iq <- q3 - q1
amplitude_iq # [1] 5.5

# Limite Inferior (LI)
limite_inf <- q1 - 1.5 * amplitude_iq
limite_inf # [1] -4.65

# Limite Superior (LS)
limite_sup <- q3 + 1.5 * amplitude_iq
limite_sup # [1] 17.35

## (D)
boxplot(conjunto)
# Interpretação: O gráfico é simétrico, ou seja, a distribuição dos dados tende
# a ser mais simétrica. Também é possível notar que existem mais elementos após
# o segundo quartil do que antes.

## (E)
library(moments)
assimetria <- skewness(conjunto)
assimetria # [1] 0.3751557
# Interpretação: O coeficiente calculado indica que a distribuição é assimétrica
# positiva

## (F)
amplitude_total <- max(conjunto) - min(conjunto)
amplitude_total # [1] 19.6

num_classes <- round(sqrt(length(conjunto)))
num_classes # [1] 7
amplitude_classes <- amplitude_total / num_classes
amplitude_classes # [1] 2.8

# Limite Inferior e Superior das Classes
limites <- function(c_inf) {
    c_sup <- c_inf + amplitude_classes
    return(list("inf" = c_inf, "sup" = c_sup))
}

c1 <- limites(min(conjunto))
c2 <- limites(c1$sup)
c3 <- limites(c2$sup)
c4 <- limites(c3$sup)
c5 <- limites(c4$sup)
c6 <- limites(c5$sup)
c7 <- limites(c6$sup)

infs <- c(c1$inf, c2$inf, c3$inf, c4$inf, c5$inf, c6$inf, c7$inf)
infs # [1] -2.3  0.5  3.3  6.1  8.9 11.7 14.5
sups <- c(c1$sup, c2$sup, c3$sup, c4$sup, c5$sup, c6$sup, c7$sup)
sups # [1]  0.5  3.3  6.1  8.9 11.7 14.5 17.3

c1_med <- (c1$inf + c1$sup) / 2
c2_med <- (c2$inf + c2$sup) / 2
c3_med <- (c3$inf + c3$sup) / 2
c4_med <- (c4$inf + c4$sup) / 2
c5_med <- (c5$inf + c5$sup) / 2
c6_med <- (c6$inf + c6$sup) / 2
c7_med <- (c7$inf + c7$sup) / 2

medios <- c(c1_med, c2_med, c3_med, c4_med, c5_med, c6_med, c7_med)
medios # [1] -0.9  1.9  4.7  7.5 10.3 13.1 15.9

#Frequencia Absoluta
frequencia_abs <- function(classe) {
    fa <- length(conjunto[conjunto >= classe$inf & conjunto < classe$sup])
    return(fa)
}

c1_fa <- frequencia_abs(c1)
c2_fa <- frequencia_abs(c2)
c3_fa <- frequencia_abs(c3)
c4_fa <- frequencia_abs(c4)
c5_fa <- frequencia_abs(c5)
c6_fa <- frequencia_abs(c6)
c7_fa <- frequencia_abs(c7)

fas <- c(c1_fa, c2_fa, c3_fa, c4_fa, c5_fa, c6_fa, c7_fa)
fas # [1]  4  7 14  8  8  3  1

# Frequencia Absoluta Acumulada
c1_faa <- c1_fa
c2_faa <- c1_faa + c2_fa
c3_faa <- c2_faa + c3_fa
c4_faa <- c3_faa + c4_fa
c5_faa <- c4_faa + c5_fa
c6_faa <- c5_faa + c6_fa
c7_faa <- c6_faa + c7_fa

faas <- c(c1_faa, c2_faa, c3_faa, c4_faa, c5_faa, c6_faa, c7_faa)
faas # [1]  4 11 25 33 41 44 45

# Frequencia Relativa
options(digits = 3)
c1_fr <- c1_fa / length(conjunto)
c2_fr <- c2_fa / length(conjunto)
c3_fr <- c3_fa / length(conjunto)
c4_fr <- c4_fa / length(conjunto)
c5_fr <- c5_fa / length(conjunto)
c6_fr <- c6_fa / length(conjunto)
c7_fr <- c7_fa / length(conjunto)

frs <- c(c1_fr, c2_fr, c3_fr, c4_fr, c5_fr, c6_fr, c7_fr)
frs # [1] 0.0889 0.1556 0.3111 0.1778 0.1778 0.0667 0.0222

# Frequencia Relativa Acumulada
c1_fra <- c1_fr
c2_fra <- c1_fra + c2_fr
c3_fra <- c2_fra + c3_fr
c4_fra <- c3_fra + c4_fr
c5_fra <- c4_fra + c5_fr
c6_fra <- c5_fra + c6_fr
c7_fra <- c6_fra + c7_fr

fras <- c(c1_fra, c2_fra, c3_fra, c4_fra, c5_fra, c6_fra, c7_fra)
fras # [1] 0.0889 0.2444 0.5556 0.7333 0.9111 0.9778 1.0000

#Frequencia Percentual
c1_fp <- c1_fa / length(conjunto) * 100
c2_fp <- c2_fa / length(conjunto) * 100
c3_fp <- c3_fa / length(conjunto) * 100
c4_fp <- c4_fa / length(conjunto) * 100
c5_fp <- c5_fa / length(conjunto) * 100
c6_fp <- c6_fa / length(conjunto) * 100
c7_fp <- c7_fa / length(conjunto) * 100

fps <- c(c1_fp, c2_fp, c3_fp, c4_fp, c5_fp, c6_fp, c7_fp)
fps # [1]  8.89 15.56 31.11 17.78 17.78  6.67  2.22

# Frequencia Percentual Acumulada
c1_fpa <- c1_fp
c2_fpa <- c1_fpa + c2_fp
c3_fpa <- c2_fpa + c3_fp
c4_fpa <- c3_fpa + c4_fp
c5_fpa <- c4_fpa + c5_fp
c6_fpa <- c5_fpa + c6_fp
c7_fpa <- c6_fpa + c7_fp

fpas <- c(c1_fpa, c2_fpa, c3_fpa, c4_fpa, c5_fpa, c6_fpa, c7_fpa)
fpas # [1]   8.89  24.44  55.56  73.33  91.11  97.78 100.00

tabela <- data.frame(infs, sups, medios, fas, faas, frs, fras, fps, fpas)
colnames(tabela) <- c("Clas_Min", "Clas_Max", "Medio", "fa", "Fa",
                      "fr", "Fr", "fp", "Fp")
tabela
#   Clas_Min Clas_Max Medio fa Fa     fr     Fr    fp     Fp
# 1     -2.3      0.5  -0.9  4  4 0.0889 0.0889  8.89   8.89
# 2      0.5      3.3   1.9  7 11 0.1556 0.2444 15.56  24.44
# 3      3.3      6.1   4.7 14 25 0.3111 0.5556 31.11  55.56
# 4      6.1      8.9   7.5  8 33 0.1778 0.7333 17.78  73.33
# 5      8.9     11.7  10.3  8 41 0.1778 0.9111 17.78  91.11
# 6     11.7     14.5  13.1  3 44 0.0667 0.9778  6.67  97.78
# 7     14.5     17.3  15.9  1 45 0.0222 1.0000  2.22 100.00

## (G)
par(mar = c(3, 2, 1, 1), mfrow = c(1, 2))

info_hist <- hist(conjunto, main = "Histograma", cex.axis = 0.75)
lines(info_hist$mids, info_hist$counts, type = "b")

info_hist$breaks <- c(infs, c7$sup)
info_hist$counts <- fas
info_hist$mids <- medios

plot(info_hist, axes = FALSE, main = "", col = "gray")

at1 <- seq(min(conjunto), max(conjunto), length.out = 6)
axis(side = 1, at = at1, cex.axis = 0.75)

at2 <- seq(0, max(info_hist$counts), by = 2)
axis(side = 2, at = at2, cex.axis = 0.75)

lines(info_hist$mids, info_hist$counts, type = "b")

# Interpretação: A partir do gráfico gerado é possível perceber que a maior
# parte dos elementos se acumulam no centro, com menos elementos nas
# extremidades.

### Exercício 2

options(digits = 6)

grupo1 <- 12
grupo2 <- 22
grupo3 <- 7
grupo4 <- 29

populacao <- grupo1 + grupo2 + grupo3 + grupo4
n <- 25

#Propocao dos estratos
w1 <- grupo1 / populacao
w2 <- grupo2 / populacao
w3 <- grupo3 / populacao
w4 <- grupo4 / populacao

#Tamanho da amostra por estrato
n1 <- w1 * n
n2 <- w2 * n
n3 <- w3 * n
n4 <- w4 * n

round(c(n1, n2, n3, n4)) # [1]  4  8  2 10


# Resposta:
# - Grupo 1: 4
# - Grupo 2: 8
# - Grupo 3: 2
# - Grupo 4: 10