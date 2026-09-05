# Akshay Jayant — Full-Stack & Network Engineering Portfolio

A multi-page interactive portfolio website showcasing Software Engineering and Network Engineering projects. Features a high-performance vanilla frontend (zero frameworks, modular CSS) backed by a robust **Java Spring Boot** REST API with a local **PostgreSQL** database and resilient **EmailJS** delivery.

> **Live Deployment:** [37akshayjayant.github.io](https://37akshayjayant.github.io)  
> **Interactive Features:** Drag-and-drop navigation, scroll-driven 3D card flips, SVG timeline, and international contact form.

---

## ✨ Features

### 🏠 Landing Page
- **Typewriter intro animation** with character-by-character typing and variable delays
- **HTML5 Drag & Drop navigation** — drag role pills ("Software Engineer" / "Network Engineer") into a drop zone to navigate directly to filtered project sections
- **Scroll-driven hero morphing** — title opacity fading, dock slide-in, auto-eject on scroll-back
- **Interactive footer spotlight** — mouse-following circular glow effect

### 💼 Projects Page
- **Categorized engineering tracks** — dedicated sections for **Software Engineering** (Full-Stack CRUD, E-Commerce) and **Network Engineering** (VLAN Routing, BharatNet Telecom Deployment)
- **Smooth accordion sections** — native `<details>` elements enhanced with JavaScript height transitions
- **Staggered card entrance animations** powered by the Web Animations API
- **Magnetic cursor badge** — floating "View Repo" / "View Details" pill following the mouse with LERP physics
- **Hash-based deep linking** — arriving from the landing page auto-opens and scrolls to the correct section

### 👤 About Page
- **Scroll-locked 3D card flip** — a 4-phase state machine (wheel + touch) flips the headshot from cartoon avatar to real photo while cross-fading bio text
- **Procedural SVG timeline** — dynamically generated Bezier path with organic wobble, drawn progressively on scroll using `strokeDashoffset` with LERP smoothing
- **Progressive reveals** — timeline dots and career cards appear synchronized with the SVG line progression
- **Resume download** button serving the PDF directly

### 📬 Contact Page
- **Country Code Selector** — international dropdown (`<select id="country-code">`) with flag emojis and calling codes for 20+ major regions (🇮🇳 `+91` default)
- **Clean Numeric Mobile Input** — hardware keydown blocking and automatic sanitization against parentheses `()`, hyphens `-`, spaces, and non-digits. Only pure numeric digits are accepted
- **No Word or Length Restrictions** — eliminated 50-character minimum restriction and counter warning styling; allows messages of any length (from short greetings to detailed project inquiries)
- **Dual-Engine Delivery**:
  1. **Spring Boot Backend**: Persists message submissions to PostgreSQL (`contact_messages` table)
  2. **EmailJS Integration**: Dispatches notifications straight to personal Gmail inbox without requiring a public backend on GitHub Pages
  3. **Direct Fallback Link**: Smart fallback providing an instant clickable link to `Akshayjayant23@gmail.com` if offline
- **Full Accessibility** — `aria-invalid`, `aria-describedby`, `aria-live`, `role="alert"`, auto-focus on first error

### ♿ Accessibility & Responsiveness
- `prefers-reduced-motion` compliance across all animations (bypasses scroll-jacking, reveals content statically)
- `prefers-contrast` high-contrast mode support
- Keyboard-accessible `:focus-visible` outlines
- Touch device fallbacks (tap-to-select hint for drag-and-drop)
- Fully responsive from 320px to ultra-wide displays

---

## 🛠️ Tech Stack

| Category | Technology |
|---|---|
| **Frontend Markup** | HTML5 (semantic, accessible, SEO-optimized) |
| **Styling** | Modular CSS3 (ITCSS architecture, CSS custom properties, flexbox/grid) |
| **Scripting** | Vanilla JavaScript (ES Modules, zero dependencies) |
| **Backend Framework** | **Java 18**, **Spring Boot 3.2.5** (Spring Web, Spring Data JPA, Hibernate) |
| **Database** | **PostgreSQL** (production) / **H2 In-Memory DB** (dev/test profile) |
| **Build Tool** | **Apache Maven 3.9** |
| **Email Service** | [EmailJS](https://www.emailjs.com/) v3 (browser SDK via CDN) |
| **Fonts** | [Google Fonts](https://fonts.google.com/) (Nunito) + [Adobe Typekit](https://fonts.adobe.com/) (Interstate Mono) |

---

## 📁 Project Structure

```
├── index.html                         # Landing / Home page
├── about.html                         # About & Experience page
├── contact.html                       # Contact form page
├── projects.html                      # Projects showcase page
│
├── landing-page.js                    # Typewriter, drag-and-drop, dock transitions
├── about.js                           # Scroll-locked 3D card flip & SVG timeline
├── contact.js                         # Validation, country code handling, EmailJS & API dispatch
├── projects.js                        # Accordions, entrance animations, magnetic cursor
├── hamburger-menu.js                  # Mobile navigation drawer controller
├── page-effects.js                    # Footer cursor spotlight effect
├── email-handler.js                   # Smart email link with Gmail compose fallback
│
├── styles/                            # Modular CSS architecture
│   ├── main.css                       # Root stylesheet (ordered @imports)
│   ├── tokens.css                     # Design tokens & CSS custom properties
│   ├── base.css                       # Reset, body defaults, scrollbar
│   ├── typography.css                 # Font declarations
│   ├── responsive.css                 # Global responsive media queries
│   ├── components/                    # Reusable UI component stylesheets
│   │   ├── nav.css                    #   Navbar & menu links
│   │   ├── hamburger.css              #   Mobile hamburger button
│   │   ├── sidebar.css                #   Slide-out drawer & overlay
│   │   ├── footer.css                 #   Curved footer with spotlight
│   │   ├── form.css                   #   Contact form, country code select & validation states
│   │   ├── timeline.css               #   Career timeline & SVG spine
│   │   └── cursor.css                 #   Magnetic cursor follower
│   ├── pages/                         # Page-specific stylesheets
│   │   ├── landing.css                #   Hero, typewriter, drag-and-drop dock
│   │   ├── projects.css               #   Accordions & project cards
│   │   └── about.css                  #   3D flip headshot & bio stack
│   └── utilities/                     # Cross-cutting utility styles
│       ├── animations.css             #   Keyframes & stagger utilities
│       ├── focus.css                  #   Accessible focus-visible rings
│       ├── touch-hint.css             #   Touch device fallbacks
│       └── accessibility.css          #   Reduced motion & high contrast
│
├── Assets/                            # Brand assets, project graphics, resume PDF
│   ├── akshay_jayant_moving.gif       # Brand logo animation
│   ├── profile image.jpeg             # Profile headshot
│   ├── Akshay_Jayant_Resume.pdf       # Printable Resume PDF
│   ├── ecommerce-project.svg          # E-Commerce artwork
│   ├── fullstack-crud.svg             # CRUD system artwork
│   ├── vlan-network.svg               # VLAN & routing artwork
│   └── bharatnet-telecom.svg          # BharatNet telecom artwork
│
└── backend/                           # Java Spring Boot REST API
    ├── pom.xml                        # Maven configuration & dependencies
    └── src/
        ├── main/
        │   ├── java/com/akshay/portfolio/
        │   │   ├── PortfolioApplication.java       # Spring Boot main class
        │   │   ├── config/
        │   │   │   ├── CorsConfig.java             # CORS mappings for frontend & GitHub Pages
        │   │   │   └── DataInitializer.java        # Database seeder on application startup
        │   │   ├── controller/
        │   │   │   ├── ContactController.java      # REST endpoints for contact messages
        │   │   │   └── ProjectController.java      # REST endpoints for project catalog
        │   │   ├── dto/                            # Data Transfer Objects & validation
        │   │   ├── entity/                         # JPA Entities (Project, ContactMessage)
        │   │   ├── exception/                      # Global exception handler
        │   │   ├── repository/                     # Spring Data JPA repositories
        │   │   └── service/                        # Business logic services
        │   └── resources/
        │       ├── application.properties          # PostgreSQL configuration
        │       └── application-dev.properties      # H2 in-memory dev profile
        └── test/                                   # MockMvc integration tests
```

---

## 🔌 REST API Endpoints

The Spring Boot backend exposes clean RESTful endpoints:

### Projects API
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/projects` | List all published projects (sorted by display order) |
| `GET` | `/api/projects?category=SOFTWARE_ENGINEERING` | Filter projects by category (`SOFTWARE_ENGINEERING`, `NETWORK_ENGINEERING`) |
| `POST` | `/api/projects` | Add a new project |

### Contact API
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/contact` | Submit a new contact message (JSON payload: name, email, phone, message) |
| `GET` | `/api/contact` | Retrieve all submitted messages (admin) |
| `PATCH` | `/api/contact/{id}/status?status=READ` | Update message status (`UNREAD` / `READ` / `ARCHIVED`) |

---

## 🚀 Getting Started

### 1. Frontend (Static Web Server)
Serve the repository root using any static server:

```bash
# Using Python
python -m http.server 8000

# Using Node.js (npx)
npx serve .
```

Then open `http://localhost:8000` in your browser.

### 2. Backend (Java Spring Boot)
Make sure **Java 18+** and **Maven 3.9+** are installed:

```bash
cd backend

# Run with in-memory H2 database (dev profile — zero configuration required)
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Or run tests
mvn test

# Package JAR & run
mvn package -DskipTests
java -Dspring.profiles.active=dev -jar target/portfolio-backend-1.0.0.jar
```

- **Backend Base URL:** `http://localhost:8080`
- **H2 Web Console:** `http://localhost:8080/h2-console` (`jdbc:h2:mem:portfolio_db`, User: `sa`, Password: *empty*)

---

## 🎨 CSS Architecture

The project uses a **modular ITCSS-style** (Inverted Triangle CSS) architecture, refactored from a single 2,139-line monolithic stylesheet into 19 focused files:

```
Tokens (design variables)
  └─ Base (reset, defaults)
       └─ Typography (fonts)
            └─ Components (nav, hamburger, sidebar, footer, form, timeline, cursor)
                 └─ Pages (landing, projects, about, temp)
                      └─ Utilities (animations, focus, touch-hint, accessibility)
                           └─ Responsive (global media queries)
```

### Design Tokens

All design values are centralized as CSS custom properties in `tokens.css`:

- **Brand palette:** `--color-primary: #F5A045` (warm orange), `--color-black: #1e1e14`
- **Typography:** `--font-primary: 'interstate-mono'`, `--font-secondary: 'Nunito'`
- **Custom easing:** `--ease-bouncy`, `--ease-aggressive`, `--ease-logo-hover`
- **Z-index scale:** `--z-base(1)` → `--z-nav(1000)` → `--z-sidebar(1001)`
- **Spacing, shadows, borders, transitions** — all tokenized

### Responsive Breakpoints

| Breakpoint | Behavior |
|---|---|
| ≥ 769px | Desktop navigation visible |
| ≤ 768px | Mobile nav, stacked footer, reduced padding |
| ≤ 480px | Compact timeline, smaller hero GIF |
| ≤ 460px | Vertical drag-and-drop dock |
| ≤ 400px | Full-width mobile sidebar |
| Touch devices | Tap-to-select hint, hidden card cursor |

---

## 🔗 Cross-Page Navigation Flow

```
                    ┌──── Drag "Software Engineer" ────→ projects.html#software-page
                    │
  index.html ───────┤
  (Landing)         │
                    ├──── Drag "Network Engineer"  ────→ projects.html#networking-page
                    │
                    └──── Footer CTA ──────────────────→ contact.html

  projects.html ────── Footer CTA ─────────────────────→ contact.html

  about.html ──────┬── Footer CTA ─────────────────────→ contact.html
                   └── Resume Button ──────────────────→ Resume PDF

  All pages ◄──────── Shared navbar links ─────────────► All pages
```

---

## 📄 License

© Akshay Jayant. All rights reserved.
