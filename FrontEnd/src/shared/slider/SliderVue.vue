<template>
  <div>
    <!-- Nav Links -->
    <nav
      class="navMenu d-flex flex-column shadow rounded-4"
      :style="[userStyles.navMenu, menuDirection, menuWidth]"
    >
      <a
        href="javscript:void(0)"
        class="closebtn"
        style="color: black"
        @click.prevent="closeMenu"
        >&times;</a
      >
      <template v-if="links.length">
        <a
          v-for="link in links"
          :key="link.id"
          :href="link.url"
          :style="link.styles"
          >{{ link.text }}</a
        >
      </template>
      <slot v-else />
    </nav>
    <!-- Hamburger Menu -->
    <nav class="navIcon" :style="[userStyles.navIcon, iconDirection]">
      <a
        href="javscript:void(0)"
        @click.prevent="toggleMenu"
        data-test-ref="navMenuLink"
      >
        <svg width="30" height="30">
          <path d="M0,5 30,5" stroke="black" stroke-width="5" />
          <path d="M0,14 30,14" stroke="black" stroke-width="5" />
          <path d="M0,23 30,23" stroke="black" stroke-width="5" />
        </svg>
      </a>
    </nav>
  </div>
</template>

<script>
import styles from "@/shared/slider/varibalies.scss";
import utilities from "@/shared/slider/utilities";
export default {
  props: {
    width: {
      type: Number,
      required: false,
      default: 250,
    },
    format: {
      type: String,
      required: false,
      default: "overlay",
      validator: (value) => ["push", "full", "overlay"].indexOf(value) > -1,
    },
    direction: {
      type: String,
      required: false,
      default: "left",
      validator: (value) => ["left", "right"].indexOf(value) > -1,
    },
    opacity: {
      type: Number,
      required: false,
      default: 0,
    },
    links: {
      type: Array,
      required: false,
      default: () => [],
    },
    customStyles: {
      type: Object,
      required: false,
      deep: true,
      default: () => ({}),
    },
  },
  data() {
    const defaultStyles = {
      navMenu: {},
      navIcon: {},
    };

    return {
      styles: styles,
      menuWidth: {
        width: 0,
      },
      userStyles: Object.assign({}, defaultStyles, this.customStyles),
    };
  },
  watch: {
    customStyles() {
      this.userStyles = Object.assign({}, this.userStyles, this.customStyles);
    },
  },
  computed: {
    menuDirection() {
      return this.direction === "right" ? { right: 0 } : { left: 0 };
    },
    iconDirection() {
      return { float: this.direction };
    },
    app() {
      return document.getElementById("app");
    },
  },
  mounted() {
    if (!this.app) {
      console.warn(
        `[Slider] The format was set to '${this.format}', but there is no element with an id 'app'. Add id='app' to the element to move.`
      );
    }
  },
  methods: {
    openMenu() {
      const width = `${this.width}px`;
      const marginDirection = `margin-${this.direction}`;

      this.menuWidth = {
        width: this.format === "full" ? "100%" : width,
      };

      if (this.app && this.format === "push") {
        this.app.style[marginDirection] = width;
        this.app.style.transition = `${marginDirection} .5s`;
      }

      if (this.opacity) {
        document.body.style.background = utilities.hexToRGB(
          styles["background-color"],
          this.opacity
        );
      }
    },
    closeMenu() {
      this.menuWidth = { width: 0 };
      if (this.app) {
        this.app.style.marginLeft = "0";
        this.app.style.marginRight = "0";
      }
      if (this.opacity) {
        document.body.style.background = styles["background-color"];
      }
    },
    toggleMenu() {
      if (this.menuWidth.width === 0) {
        this.openMenu();
      } else {
        this.closeMenu();
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.navMenu {
  margin-top: 95px;
  padding-top: 55px;
  height: 100%;
  width: 0;
  position: absolute;
  z-index: 1;
  top: 0;
  background: #ffff;
  overflow-x: hidden;
  transition: 0.5s;
  a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #ffff;
    display: block;
    transition: 0.3s;
    &:hover {
      color: #e0e0e0;
    }
  }
  .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
  }
}

@media screen and (max-height: 450px) {
  .navMenu {
    padding-top: 15px;
    a {
      font-size: 18px;
    }
  }
}
</style>
