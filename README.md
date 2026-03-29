# 📚 BiblioGestion — Système de Gestion de Bibliothèque

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?logo=springboot)
![Java](https://img.shields.io/badge/Java-21-orange?logo=java)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-green?logo=thymeleaf)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-purple?logo=bootstrap)
![Maven](https://img.shields.io/badge/Maven-3.x-red?logo=apachemaven)
![Lombok](https://img.shields.io/badge/Lombok-1.18-pink?logo=lombok)

> Application Web de gestion de bibliothèque développée avec **Spring Boot**, **Thymeleaf**, **Spring Data JPA** et **MySQL**. Elle permet de gérer les ouvrages, les écrivains et les prêts avec un tableau de bord statistique complet.

---

## 🎬 Démonstration

https://github.com/user-attachments/assets/2380dd8d-5567-4564-a730-331638bcea14


https://github.com/user-attachments/assets/869c305c-d4bd-4e50-a5a5-4ff58a849b56


---

## ✨ Fonctionnalités

### 📖 Gestion des Ouvrages
- ➕ Ajouter / ✏️ Modifier / 🗑️ Supprimer un ouvrage
- 🔄 Basculer la disponibilité (disponible / indisponible)
- 🔍 Filtrer par genre, désignation, écrivain ou disponibilité

### ✍️ Gestion des Écrivains
- ➕ Ajouter / ✏️ Modifier / 🗑️ Supprimer un écrivain
- 🔍 Rechercher par nom ou par pays

### 🔄 Gestion des Prêts
- ➕ Créer un prêt sur un ouvrage disponible
- ✅ Enregistrer le retour d'un ouvrage
- ⚠️ Détection automatique des retards
- 🔍 Filtrer par état (En cours / Rendu / En retard)

### 📊 Statistiques & Tableau de Bord
- 📅 Nombre de prêts par mois (graphique barres)
- 🏆 Écrivains les plus empruntés (graphique donut)
- ⚠️ Taux de retard global
- 🥇🥈🥉 Classement des écrivains populaires

---


## 🗄️ Base de Données

### Entités & Relations

<img width="1555" height="463" alt="Screenshot 2026-03-29 230029" src="https://github.com/user-attachments/assets/328263d9-3dc5-4983-afee-8ad11f85bc3a" />

<img width="1560" height="625" alt="Screenshot 2026-03-29 230050" src="https://github.com/user-attachments/assets/0f8a152f-47eb-44a5-ba87-323ea69aa811" />

<img width="1555" height="584" alt="Screenshot 2026-03-29 230121" src="https://github.com/user-attachments/assets/b0d56dc7-0b6c-43a6-a759-8abddb6da821" />


### Tables générées automatiquement

<img width="1557" height="565" alt="Screenshot 2026-03-29 225917" src="https://github.com/user-attachments/assets/fa083239-bf0c-4075-ab49-16153db20513" />

---

## ⚙️ Configuration

### Prérequis
| Outil | Version |
|-------|---------|
| ☕ Java | 21+ |
| 🐬 MySQL | 8.0+ (XAMPP) |
| 🔧 Maven | 3.x |
| 💡 IntelliJ IDEA | Recommandé |


### Étape 5 — Accéder à l'application

| Page | URL |
|------|-----|
| 🏠 Accueil | http://localhost:8080 |
| ✍️ Écrivains | http://localhost:8080/ecrivains |
| 📖 Ouvrages | http://localhost:8080/ouvrages |
| 🔄 Prêts | http://localhost:8080/prets |
| 📊 Statistiques | http://localhost:8080/prets/stats |

---

## 🔧 Technologies Utilisées

| Technologie | Rôle |
|-------------|------|
| ☕ Java 21 | Langage principal |
| 🌱 Spring Boot 3.2.5 | Framework backend |
| 🍃 Thymeleaf | Moteur de templates |
| 🗄️ Spring Data JPA | Couche d'accès aux données |
| 🐬 MySQL | Base de données |
| ✅ Hibernate Validator | Validation des formulaires |
| 🎨 Bootstrap 5.3 | Framework CSS |
| 📊 Chart.js | Graphiques statistiques |
| ⚡ Lombok | Réduction du boilerplate |
| 🔧 Maven | Gestion des dépendances |

---
