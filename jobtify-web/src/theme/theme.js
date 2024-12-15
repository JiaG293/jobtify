import { createTheme } from '@mui/material/styles';

const palette = {
  primary: {
    light: '#63ccff',
    main: '#009be5',
    dark: '#006db3',
  },
};

const typography = {
  h5: {
    fontWeight: 500,
    fontSize: 26,
    letterSpacing: 0.5,
  },
};

const shape = {
  borderRadius: 8,
};

const mixins = {
  toolbar: {
    minHeight: 48,
  },
};

const components = {
  MuiTab: {
    defaultProps: {
      disableRipple: true,
    },
  },
  MuiDrawer: {
    styleOverrides: {
      paper: {
        backgroundColor: '#081627',
      },
    },
  },
  MuiButton: {
    styleOverrides: {
      root: {
        textTransform: 'none',
      },
      contained: {
        boxShadow: 'none',
        '&:active': {
          boxShadow: 'none',
        },
      },
    },
  },
  MuiTabs: {
    styleOverrides: {
      root: {
        marginLeft: 1,
      },
      indicator: {
        height: 3,
        borderTopLeftRadius: 3,
        borderTopRightRadius: 3,
        backgroundColor: '#fff',
      },
    },
  },
  MuiTab: {
    styleOverrides: {
      root: {
        textTransform: 'none',
        margin: '0 16px',
        minWidth: 0,
        padding: 0,
        '@media (min-width:960px)': {
          padding: 0,
          minWidth: 0,
        },
      },
    },
  },
  MuiIconButton: {
    styleOverrides: {
      root: {
        padding: 1,
      },
    },
  },
  MuiTooltip: {
    styleOverrides: {
      tooltip: {
        borderRadius: 4,
      },
    },
  },
  MuiDivider: {
    styleOverrides: {
      root: {
        backgroundColor: 'rgba(255, 255, 255, 0.15)',
      },
    },
  },
  MuiListItemButton: {
    styleOverrides: {
      root: {
        '&.Mui-selected': {
          color: '#4fc3f7',
        },
      },
    },
  },
  MuiListItemText: {
    styleOverrides: {
      primary: {
        fontSize: 14,
        fontWeight: 500,
      },
    },
  },
  MuiListItemIcon: {
    styleOverrides: {
      root: {
        color: 'inherit',
        minWidth: 'auto',
        marginRight: 2,
        '& svg': {
          fontSize: 20,
        },
      },
    },
  },
  MuiAvatar: {
    styleOverrides: {
      root: {
        width: 32,
        height: 32,
      },
    },
  },
};

const theme = createTheme({
  palette,
  typography,
  shape,
  mixins,
  components,
});

export default theme;