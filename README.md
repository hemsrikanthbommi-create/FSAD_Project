# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend using TypeScript with type-aware lint rules enabled. Check out the [TS template](https://github.com/vitejs/vite/tree/main/packages/create-vite/template-react-ts) for information on how to integrate TypeScript and [`typescript-eslint`](https://typescript-eslint.io) in your project.

## Spring Boot backend integration

A new Spring Boot backend has been added under `backend/`.

### Run the backend

1. Install Java 17+.
2. Open a terminal in `backend/`.
3. Run:

```bash
mvn spring-boot:run
```

The backend starts on `http://localhost:8080` and exposes the following endpoints:

- `GET /api/hello`
- `GET /api/users`
- `GET /api/users/{id}`
- `POST /api/users` with JSON body `{ "name": "...", "email": "..." }`
- `GET /api/echo?message=hello`
- `GET /api/articles`
- `GET /api/articles/{id}`
- `POST /api/articles` with JSON body `{ "title": "...", "content": "...", "author": "..." }`
- `GET /api/videos`
- `GET /api/videos/{id}`
- `POST /api/videos` with JSON body `{ "title": "...", "description": "...", "url": "...", "durationSeconds": 120 }`

The backend now uses an in-memory H2 database for articles and videos.
You can open the H2 console at `http://localhost:8080/h2-console` and connect with:

- JDBC URL: `jdbc:h2:mem:projectdb`
- User name: `sa`
- Password: (leave empty)

### Run the frontend

From the project root:

```bash
npm install
npm run dev
```

The Vite dev server proxies `/api` requests to the Spring Boot backend, so the React app can fetch `/api/hello` without CORS configuration.
