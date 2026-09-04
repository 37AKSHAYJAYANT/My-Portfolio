# Akshay Jayant — Engineering, Developer & Design Portfolio

A multi-page interactive portfolio website showcasing Software Engineering and Network Engineering projects. Built entirely with vanilla HTML, CSS, and JavaScript — no frameworks, no build tools, no bundlers.

> **Note:** Interactive features such as the drag-and-drop API on the landing page work best on Desktop. The website supports responsive design for devices as small as 320px in width.

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
- **Resume download** button

### 📬 Contact Page
- **Real-time form validation** with eager error recovery (errors clear as you type)
- **US phone auto-formatting** — strips non-digits and formats as `(XXX) XXX-XXXX`
- **Live character counter** — color transitions from neutral → warning → valid (50–2000 chars)
- **EmailJS integration** — client-side email dispatch without a backend server
- **Full accessibility** — `aria-invalid`, `aria-describedby`, `aria-live`, `role="alert"`, auto-focus on first error

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
| **Markup** | HTML5 (semantic, accessible) |
| **Styling** | CSS3 (modular architecture, custom properties, animations) |
| **Scripting** | Vanilla JavaScript (ES Modules) |
| **Email Service** | [EmailJS](https://www.emailjs.com/) v3 (via CDN) |
| **Fonts** | [Google Fonts](https://fonts.google.com/) (Nunito) + [Adobe Typekit](https://fonts.adobe.com/) (Interstate Mono) |
| **Build Tools** | None — zero-config, no bundlers |

---

## 📁 Project Structure

```
├── index.html                     # Landing / Home page
├── about.html                     # About & Experience
├── contact.html                   # Contact form
├── projects.html                  # Projects (Software & Network Engineering)
│
├── landing-page.js                # Typewriter, drag-and-drop, scroll effects
├── about.js                       # Scroll-locked card flip, SVG timeline
├── contact.js                     # Form validation, EmailJS dispatch
├── projects.js                    # Accordions, entrance animations, magnetic cursor
├── hamburger-menu.js              # Mobile navigation drawer
├── page-effects.js                # Footer spotlight, navbar theme switching
│
├── styles/                        # Modular CSS architecture
│   ├── main.css                   # Entry point (ordered @imports)
│   ├── tokens.css                 # Design tokens & CSS custom properties
│   ├── base.css                   # Reset, body defaults, scrollbar
│   ├── typography.css             # Font assignments
│   ├── responsive.css             # Global media queries
│   ├── components/                # Reusable UI components
│   │   ├── nav.css                #   Sticky navbar & pill links
│   │   ├── hamburger.css          #   Mobile menu button
│   │   ├── sidebar.css            #   Slide-out drawer & overlay
│   │   ├── footer.css             #   Curved sticky footer
│   │   ├── form.css               #   Contact form & validation states
│   │   ├── timeline.css           #   Career timeline & SVG spine
│   │   └── cursor.css             #   Cursor follower effects
│   ├── pages/                     # Page-specific styles
│   │   ├── landing.css            #   Hero, typewriter, drag-and-drop dock
│   │   ├── projects.css           #   Accordions & project cards
│   │   ├── about.css              #   3D flip headshot, bio text stack
│   │   └── temp.css               #   Scroll spacer sections
│   └── utilities/                 # Cross-cutting concerns
│       ├── animations.css         #   Keyframes & stagger utilities
│       ├── focus.css              #   :focus-visible rings
│       ├── touch-hint.css         #   Touch device fallbacks
│       └── accessibility.css      #   Reduced motion & high contrast
│
└── Assets/
    ├── akshay_jayant_moving.gif   # Animated brand logo
    ├── wavingDude.gif             # Animated character illustration
    ├── irlHeadshot.jpg            # Headshot photo
    ├── ecommerce-project.svg      # E-Commerce project card artwork
    ├── fullstack-crud.svg         # Full-Stack CRUD project card artwork
    ├── vlan-network.svg           # VLAN & routing project card artwork
    ├── bharatnet-telecom.svg      # BharatNet telecom project card artwork
    └── ...                        # Navigation UI icons (menu, close)
```

---

## 🚀 Getting Started

No build step required. Just serve the files with any static server:

```bash
# Using Python
python -m http.server 8000

# Using Node.js (npx)
npx serve .

# Using VS Code
# Install the "Live Server" extension and click "Go Live"
```

Then open `http://localhost:8000` in your browser.

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
